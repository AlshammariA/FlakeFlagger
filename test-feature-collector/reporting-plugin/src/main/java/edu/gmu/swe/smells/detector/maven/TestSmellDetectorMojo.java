package edu.gmu.swe.smells.detector.maven;

import edu.gmu.swe.demographics.*;
import edu.gmu.swe.smells.Utils;
import edu.gmu.swe.smells.coverage.JacocoCoverageSource;
import edu.gmu.swe.smells.detector.*;
import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.detector.internal.DetectorEntryPoint;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.metadata.ArtifactMetadataSource;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.*;
import org.apache.maven.artifact.resolver.filter.ArtifactFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.surefire.report.ReportTestSuite;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.artifact.filter.ScopeArtifactFilter;
import org.apache.maven.shared.dependency.tree.DependencyNode;
import org.apache.maven.shared.dependency.tree.DependencyTreeBuilder;
import org.apache.maven.shared.dependency.tree.DependencyTreeBuilderException;
import org.apache.maven.shared.dependency.tree.traversal.CollectingDependencyNodeVisitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.jacoco.core.tools.ExecFileLoader;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

@Mojo(name = "detectSmells", defaultPhase = LifecyclePhase.VERIFY)
public class TestSmellDetectorMojo extends AbstractMojo {
	Log consoleLogger;
	PrintWriter fw;
	HashSet<MavenProject> visited = new HashSet<MavenProject>();
	HashSet<String> dependenciesWithSourceDirs = new HashSet<String>();
	HashSet<String> dependenciesWithoutSourceDirs = new HashSet<String>();
	@Component
	protected MavenProject project;
	protected String outputFile = System.getenv("KP_JACOCO_OUTPUT_FILE");
	//	@Parameter(readonly = true, required = true, property = "debugCovFile")
//	private String covFile;
	@Parameter(readonly = true, required = true, property = "jacocoFile")
	protected String jacocoFile;
	@Parameter(readonly = true, required = true)
	protected String[] buildOutputDirs;

	@Parameter(readonly = true, required = true)
	protected String gitDir;
	//	@Parameter(readonly = true, required = true, property = "reportedTestsFile")
//	private String reportedTestsFile;
	@Parameter(readonly = true, required = true, property = "maven.test.failure.ignore", defaultValue = "true")
	protected boolean testFailureIgnore;
	@Parameter(readonly = true, required = true, defaultValue = "false")
	protected boolean isLastExec;
	protected ExecFileLoader loader;
	protected boolean doDeflaker = false;
	@Parameter(defaultValue = "${project.remoteArtifactRepositories}", readonly = true, required = true)
	protected List<ArtifactRepository> remoteRepositories;
	@Parameter(defaultValue = "${localRepository}", readonly = true, required = true)
	protected ArtifactRepository localRepository;
	@Parameter(defaultValue = "${reactorProjects}", readonly = true, required = true)
	protected List<MavenProject> reactorProjects;
	@Component
	protected ArtifactResolver resolver;
	@Component
	protected ArtifactFactory artifactFactory;
	@Component
	protected ArtifactMetadataSource artifactMetadataSource;
	@Component
	protected ArtifactCollector artifactCollector;
	@Component
	protected DependencyTreeBuilder treeBuilder;
	@Parameter(defaultValue = "false", property="smells.skip")
	protected boolean skipSmellDetection;

	private static boolean equals(Artifact o1, Artifact o2) {
		return o1.getGroupId().equals(o2.getGroupId()) && o1.getArtifactId().equals(o2.getArtifactId()) && o1.getVersion().equals(o2.getVersion()) && o1.getType().equals(o2.getType());
	}

	private void collectDependencies(MavenProject project) throws DependencyTreeBuilderException {
		if (visited.contains(project))
			return;
		visited.add(project);

		if(Files.exists(Paths.get(project.getBuild().getOutputDirectory()))) {
			dependenciesWithSourceDirs.add(project.getBuild().getOutputDirectory());
		}
		if(Files.exists(Paths.get(project.getBuild().getTestOutputDirectory()))) {
			dependenciesWithSourceDirs.add(project.getBuild().getTestOutputDirectory());
		}

		ArtifactFilter artifactFilter = new ScopeArtifactFilter(null);

		DependencyNode rootNode = treeBuilder.buildDependencyTree(project, localRepository, artifactFactory, artifactMetadataSource, artifactFilter, artifactCollector);

		CollectingDependencyNodeVisitor visitor = new CollectingDependencyNodeVisitor();

		rootNode.accept(visitor);

		List<DependencyNode> nodes = visitor.getNodes();
		for (DependencyNode dependencyNode : nodes) {
			int state = dependencyNode.getState();
			Artifact artifact = dependencyNode.getArtifact();
			// Check to make sure that the artifact isn't part of the
			// reactor projects.
			boolean found = false;
			for (MavenProject p : reactorProjects) {
				if (equals(p.getArtifact(), artifact)) {
					// Ah-ha
					collectDependencies(p);
					found = true;
				}
			}
			if (found)
				continue;
			try {
				// System.out.println("Resolving " + artifact);
				// resolver.resolve(artifact, remoteRepositories,
				// localRepository);
				ArtifactResolutionResult res = resolver.resolveTransitively(Collections.singleton(artifact), project.getArtifact(), remoteRepositories, localRepository, artifactMetadataSource);
				for (Object r : res.getArtifacts()) {
					File f = ((Artifact) r).getFile();
					if(f.exists()) {
						dependenciesWithSourceDirs.add(f.getAbsolutePath());
						dependenciesWithoutSourceDirs.add(f.getAbsolutePath());
					}
				}
			} catch (ArtifactResolutionException e) {
//				if (debug)
				e.printStackTrace();
			} catch (ArtifactNotFoundException e) {
//				if (debug)
				e.printStackTrace();
			}
		}
	}

	protected void logInfo(String str) {
		consoleLogger.info(str);
		if (fw != null)
			fw.println("[INFO] " + str);
	}

	protected void logWarn(String str) {
		consoleLogger.warn(str);
		if (fw != null)
			fw.println("[WARN] " + str);

	}

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		if (outputFile == null) {
			outputFile = "jacoco.output";
//			throw new MojoFailureException("Error: please set KP_JACOCO_OUTPUT_FILE");
		}
		if (!isLastExec || !Files.exists(Paths.get(project.getBuild().getDirectory()))) {
			System.err.println("Skipping execution.");
			return;
		}
		List<ReportTestSuite> tests = null;

		String rootProjectName = Paths.get(gitDir).getParent().getFileName().toString();
		try {
		consoleLogger = getLog();


			int uncoveredClasses = 0;
			int uncoveredLines = 0;
			int uncoveredMethods = 0;
			if (System.getProperty("jacoco.report") != null) {
				try {
					fw = new PrintWriter(new FileWriter(System.getProperty("diffCov.report")));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			logInfo("------------------------------------------------------------------------");
			logInfo("TEST SMELL ANALYSIS");
			logInfo(project.getName() + ":" + project.getArtifactId());
			logInfo("------------------------------------------------------------------------");

			final HashMap<String, HashMap<String, boolean[]>> dataPerSession = new HashMap<String, HashMap<String, boolean[]>>();
			final LinkedList<String> nonTestSourceDirs = new LinkedList<>();
			final LinkedList<String> testSourceDirs = new LinkedList<>();


			try {
				if(!Files.exists(Paths.get(jacocoFile))){
					logInfo("No tests ran in this module. Skipping execution.");
					return;
				}

				File of = new File(outputFile);
				if (of.exists()) {
					System.out.println("File " + of + " already exists, bailing");
					return;
				}
//				if (project != null) {
//					String buildDirsProp = project.getProperties().getProperty("allBuildDirs");
//					if (buildDirsProp != null) {
//						buildOutputDirs = buildDirsProp.split(",");
//					}
//				}

//				LazyDependencyResolver r = new LazyDependencyResolver();
                String[] surefireClasspath = project.getProperties().getProperty("flakyTestClasspath").split(":");
				int extraCPElements = 0;
				if(Files.exists(Paths.get(project.getBuild().getOutputDirectory())))
				    extraCPElements++;
				if(Files.exists(Paths.get(project.getBuild().getTestOutputDirectory())))
				    extraCPElements++;
				String[] cp = new String[surefireClasspath.length+extraCPElements];
				System.arraycopy(surefireClasspath,0,cp,extraCPElements,surefireClasspath.length);
				if(Files.exists(Paths.get(project.getBuild().getOutputDirectory()))) {
					extraCPElements--;
					cp[extraCPElements] = project.getBuild().getOutputDirectory();
				}
				if(Files.exists(Paths.get(project.getBuild().getTestOutputDirectory()))) {
					extraCPElements--;
					cp[extraCPElements] = project.getBuild().getTestOutputDirectory();
				}
				LinkedList<String> sp = new LinkedList<String>();
//				for (MavenProject p : reactorProjects) {
//					testSourceDirs.add(p.getBuild().getTestSourceDirectory());
//					nonTestSourceDirs.add(p.getBuild().getSourceDirectory());
//					if (Files.exists(Paths.get(p.getBuild().getSourceDirectory())))
//						sp.add(p.getBuild().getSourceDirectory());
//					if (Files.exists(Paths.get(p.getBuild().getTestSourceDirectory())))
//						sp.add(p.getBuild().getTestSourceDirectory());
//				}
				testSourceDirs.add(project.getBuild().getTestSourceDirectory());
				nonTestSourceDirs.add(project.getBuild().getSourceDirectory());
				if (Files.exists(Paths.get(project.getBuild().getSourceDirectory())))
					sp.add(project.getBuild().getSourceDirectory());
				if (Files.exists(Paths.get(project.getBuild().getTestSourceDirectory())))
					sp.add(project.getBuild().getTestSourceDirectory());

				final HashSet<String> productionClassFiles = new HashSet<>();
				final HashSet<String> testClassFiles = new HashSet<>();
				for (String dir : nonTestSourceDirs) {
					Files.walkFileTree(Paths.get(dir), new FileVisitor<Path>() {
						@Override
						public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
							productionClassFiles.add(file.toString());
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
							return FileVisitResult.CONTINUE;
						}
					});
				}
				for (String dir : testSourceDirs) {
					Files.walkFileTree(Paths.get(dir), new FileVisitor<Path>() {
						@Override
						public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
							testClassFiles.add(file.toString());
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
							return FileVisitResult.CONTINUE;
						}
					});
				}

				String[] sps = new String[sp.size()];
				sps = sp.toArray(sps);
				JacocoCoverageSource jacocoCoverageSource = new JacocoCoverageSource(jacocoFile, buildOutputDirs);

				HashMap<String,TestContext> testContextMap = DetectorEntryPoint.buildTestContextMap(productionClassFiles,testClassFiles,sps,cp,jacocoCoverageSource);
				if(!skipSmellDetection) {
					LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
//				detectors.add(CallsSleepSmellDetector.class);
					detectors.add(AssertionRouletteDetector.class);
					detectors.add(ConditionalTestDetector.class);
					detectors.add(EagerDetector.class);
					detectors.add(FireAndForgetSmellDetector.class);
					detectors.add(IndirectTestingDetector.class);
					detectors.add(MysteryGuestSmellDetector.class);
					detectors.add(ResourceOptimismSmellDetector.class);
					detectors.add(RunWarDetector.class);

					DetectorEntryPoint p = new DetectorEntryPoint();

					LinkedList<DetectedSmellInstance> found = DetectorEntryPoint.detectSmells(detectors,
							testContextMap);
					FileOutputStream fosDetails = new FileOutputStream(project.getBuild().getDirectory() + "/smells.csv");
					PrintWriter printer = new PrintWriter(fosDetails);
					FileOutputStream fos = new FileOutputStream(project.getBuild().getDirectory() + "/smells-pretty.csv");
					PrintWriter prettyPrinter = new PrintWriter(fos);
					printer.println("project,testClassName,testMethodName,smell");
					prettyPrinter.print("project,testClassName,testMethodName,");
					LinkedList<String> smellTagsInOrder = new LinkedList<>();
					for (Class<? extends AbstractTestSmellDetector> detectorClass : detectors) {
						try {
							AbstractTestSmellDetector d = detectorClass.newInstance();
							smellTagsInOrder.add(d.getName());
							prettyPrinter.print(d.getName());
							prettyPrinter.print(",");
						} catch (InstantiationException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
					prettyPrinter.println();
					HashMap<TestContext, HashSet<String>> overallStatus = new HashMap<>();
					if (found.size() > 0) {
						logWarn("Test smell results:");
						for (DetectedSmellInstance each : found) {
							if (!overallStatus.containsKey(each.test))
								overallStatus.put(each.test, new HashSet<String>());
							if (each.smell != null) {
								logWarn("Test: " + each.test.getTestClassName() + "#" + each.test.getTestMethodName() + ", Smell: " + each.smell);
								overallStatus.get(each.test).add(each.smell);
								printer.print(Utils.escapeStrForOutput(rootProjectName));
								printer.print(',');
								printer.print(Utils.escapeStrForOutput(each.test.getTestClassName()));
								printer.print(',');
								printer.print(Utils.escapeStrForOutput(each.test.getTestMethodName()));
								printer.print(',');
								printer.print(each.smell);
								printer.println();
							}
						}
					}
					for (TestContext t : overallStatus.keySet()) {
						prettyPrinter.print(Utils.escapeStrForOutput(rootProjectName));
						prettyPrinter.print(',');
						prettyPrinter.print(Utils.escapeStrForOutput(t.getTestClassName()));
						prettyPrinter.print(',');
						prettyPrinter.print(Utils.escapeStrForOutput(t.getTestMethodName()));
						prettyPrinter.print(',');
						for (String smell : smellTagsInOrder) {
							if (overallStatus.get(t).contains(smell)) {
								prettyPrinter.print("1,");
							} else
								prettyPrinter.print("0,");
						}
						prettyPrinter.println();
					}
					prettyPrinter.close();
					printer.close();
				}
				System.out.println("-----Test Demographic Reports------");
				LinkedList<DemographicReporter> demographicReporters = new LinkedList<>();
				String baseReportsDirectory = project.getBuild().getDirectory()+"/demographic-reports/";
				new File(baseReportsDirectory).mkdir();
				demographicReporters.add(new TestMethodExporterReporter(baseReportsDirectory+"testMethods/"));
				demographicReporters.add(new CoveredStatementChurnReporter(baseReportsDirectory+"churn.csv"));
				demographicReporters.add(new LibrariesUsageReporter(baseReportsDirectory+"LibrariesUsages.csv"));
				demographicReporters.add(new ExecutionTimeReporter(baseReportsDirectory+"ExecutionTime.csv", buildOutputDirs));
				demographicReporters.add(new BasicDemographicReporter(baseReportsDirectory+"basicDemographics.csv"));
				Repository repo = null;
				try {
					repo = new FileRepositoryBuilder().setGitDir(new File(gitDir)).build();
				}catch(Throwable t)
				{
					//ignore
				}

				for(DemographicReporter rep: demographicReporters) {
					try {
						rep.getDemographicResults(testContextMap.values(), project, repo, rootProjectName);
					} catch (Throwable t) {
						t.printStackTrace();
						System.err.println("Warning: Reporter threw error");
					}
					rep.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
				throw new MojoFailureException(e.getMessage());
			}
		} finally {
			if (fw != null)
				fw.close();

		}

	}

	public class LazyDependencyResolver {
		String[] cpArray;

		public String[] getCP() throws MojoExecutionException {
			if (cpArray == null) {
				try {
//					for (MavenProject p : reactorProjects)
					collectDependencies(project);
					dependenciesWithSourceDirs.remove(project.getBuild().getOutputDirectory());
					dependenciesWithSourceDirs.remove(project.getBuild().getTestOutputDirectory());

				} catch (DependencyTreeBuilderException e) {
					e.printStackTrace();
					throw new MojoExecutionException("", e);
				}

				cpArray = new String[dependenciesWithSourceDirs.size()];
				dependenciesWithSourceDirs.toArray(cpArray);
			}
			return cpArray;
		}
	}
}
