package edu.gmu.swe.smells.detector.internal;

import edu.gmu.swe.kp.report.jacoco.JacocoRunInfo;
import edu.gmu.swe.kp.report.jacoco.SessionCoverageVisitor;
import edu.gmu.swe.smells.coverage.CoverageSource;
import edu.gmu.swe.smells.coverage.JacocoCoverageSource;
import edu.gmu.swe.smells.detector.*;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.internal.analysis.StringPool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DetectorEntryPoint {
	public static String[] toArray(String in)
	{
		return in.split(":");
	}
	public static void main(String[] args) throws Exception {
		String sourcePath = args[0];
		String classPath = args[1];
		String jacocoFile = args[2];
		String classFileDirectories = args[3];
		String projectName = args[4];
		String outputDirectory = args[5];

		JacocoCoverageSource jacocoSource = new JacocoCoverageSource(jacocoFile, toArray(classFileDirectories));
		final HashSet<String> sourceClasses = new HashSet<>();
		final HashSet<String> testClasses = new HashSet<>();
		String[] sp = toArray(sourcePath);
		String[] cp = toArray(classPath);


		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(CallsSleepSmellDetector.class);

		for (String s : sp) {
			Files.walkFileTree(Paths.get(s), new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if (file.toString().replace("test-smell-detector","").contains("test"))
						testClasses.add(file.toString());
					else
						sourceClasses.add(file.toString());
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}
			});
		}
		JDTContext c = new JDTContext(sourceClasses, testClasses, sp, cp);

		detectors.add(CallsSleepSmellDetector.class);
		detectors.add(AssertionRouletteDetector.class);
		detectors.add(ConditionalTestDetector.class);
		detectors.add(EagerDetector.class);
		detectors.add(FireAndForgetSmellDetector.class);
		detectors.add(IndirectTestingDetector.class);
		detectors.add(MysteryGuestSmellDetector.class);
		detectors.add(ResourceOptimismSmellDetector.class);
		detectors.add(RunWarDetector.class);

		DetectorEntryPoint p = new DetectorEntryPoint();

		HashMap<String,TestContext> tests = DetectorEntryPoint.buildTestContextMap(sourceClasses,testClasses,sp,cp,jacocoSource);
		LinkedList<DetectedSmellInstance> found = DetectorEntryPoint.detectSmells(detectors,
				tests);
		FileOutputStream fosDetails = new FileOutputStream(outputDirectory+ "/smells.csv");
		PrintWriter printer = new PrintWriter(fosDetails);
		FileOutputStream fos = new FileOutputStream(outputDirectory + "/smells-pretty.csv");
		PrintWriter prettyPrinter = new PrintWriter(fos);
		printer.println("project,testClassName,testMethodName,smell");
		prettyPrinter.print("project,testClassName,testMethodName,");
		LinkedList<String> smellTagsInOrder = new LinkedList<>();
		for(Class<? extends AbstractTestSmellDetector> detectorClass : detectors)
		{
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
		HashMap<TestContext,HashSet<String>> overallStatus = new HashMap<>();
		if (found.size() > 0) {
			System.out.println("Test smell results:");
			for (DetectedSmellInstance each : found) {
				if(!overallStatus.containsKey(each.test))
					overallStatus.put(each.test,new HashSet<String>());
				if(each.smell != null) {
					System.out.println("Test: " + each.test.getTestClassName() + "#" + each.test.getTestMethodName() + ", Smell: " + each.smell);
					overallStatus.get(each.test).add(each.smell);
					printer.print(projectName);
					printer.print(',');
					printer.print(each.test.getTestClassName());
					printer.print(',');
					printer.print(each.test.getTestMethodName());
					printer.print(',');
					printer.print(each.smell);
					printer.println();
				}
			}
		}
		for(TestContext t : overallStatus.keySet())
		{
			prettyPrinter.print(projectName);
			prettyPrinter.print(',');
			prettyPrinter.print(t.getTestClassName());
			prettyPrinter.print(',');
			prettyPrinter.print(t.getTestMethodName());
			prettyPrinter.print(',');
			for(String smell : smellTagsInOrder){
				if(overallStatus.get(t).contains(smell))
				{
					prettyPrinter.print("1,");
				}
				else
					prettyPrinter.print("0,");
			}
			prettyPrinter.println();
		}
		prettyPrinter.close();
		printer.close();



	}

	public static HashMap<String, TestContext> buildTestContextMap(
	                                                          Collection<String> productionClassFiles, Collection<String> testClassFiles, String[] sps, String[] cp,
	                                                          CoverageSource coverageSource) {

		final StringPool stringPool = new StringPool();
//		System.out.println("Production classes:");
//		for(String s : productionClassFiles)
//			System.out.println(s);
//
//		System.out.println("Tests:");
//		for(String s : testClassFiles)
//			System.out.println(s);
		final JDTContext jdtContext = new JDTContext(productionClassFiles, testClassFiles, sps, cp);



		HashSet<String> allClasses = new HashSet<>();
		allClasses.addAll(testClassFiles);
		allClasses.addAll(productionClassFiles);
		final CoverageBuilder builder = new CoverageBuilder();
		final JacocoRunInfo info = new JacocoRunInfo();
		info.runInfoPerTest = new HashMap<String, JacocoRunInfo>();

		final HashMap<String, TestContext> tests = new HashMap<>();

		SessionCoverageVisitor vis = new SessionCoverageVisitor() {
			@Override
			public void preVisitClass(String probeClass) {
			}

			@Override
			public void preVisitMethod(String probeClass, String probeMethod) {

			}

			@Override
			public void endVisitMethod(String probeClass, String probeMethod, int nCoveredLines, int nTotalLines, int nInsncovered, int nInsnTotal, int diffLinesCovered, int nDiffLinesTotal) {

			}

			@Override
			public void postVisitClass(String probeClass) {
			}

			@Override
			public void visitCoverage(String testClassName, String testMethodName, String probeClass, HashSet<Integer> coveredLines, int nTotalLines, int nInsncovered, int nInsnTotal, int nDiffCovered, int nDiffLinesTotal) {
				String tcn = testClassName + "#" + testMethodName;
				if (!tests.containsKey(tcn))
					tests.put(tcn, new TestContext(testClassName, testMethodName, jdtContext.getMethod(testClassName, testMethodName, null), jdtContext));
				tests.get(tcn).addHitLines(probeClass, coveredLines);
			}
		};
		coverageSource.visitCoverage(vis);
		return tests;
	}

	public static LinkedList<DetectedSmellInstance> detectSmells(final Iterable<Class<? extends AbstractTestSmellDetector>> detectorTypes,
	                                                             HashMap<String, TestContext> tests
	) {
		final LinkedList<DetectedSmellInstance> ret = new LinkedList<>();

		final LinkedList<AbstractTestSmellDetector> detectors = new LinkedList<>();
		for (Class<? extends AbstractTestSmellDetector> c : detectorTypes) {
			try {
				detectors.add(c.newInstance());
			} catch (InstantiationException | IllegalAccessException ex) {

			}
		}
		for (TestContext test : tests.values()) {
			boolean hasAnySmell = false;
			if (test.getTestMethodBody() != null)
				for (AbstractTestSmellDetector detector : detectors) {
					if (detector.checkForSmell(test, tests.values())) {
						ret.add(new DetectedSmellInstance(detector.getName(), test));
						hasAnySmell = true;
					}
				}
			if (!hasAnySmell)
				ret.add(new DetectedSmellInstance(null, test));

		}
		return ret;
	}
}
