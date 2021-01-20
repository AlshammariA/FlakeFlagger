package edu.gmu.swe.demographics;

import edu.gmu.swe.smells.Utils;
import edu.gmu.swe.smells.coverage.JacocoCoverageSource;
import edu.gmu.swe.smells.detector.internal.DetectorEntryPoint;
import edu.gmu.swe.smells.detector.internal.JDTContext;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.apache.maven.project.MavenProject;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LogCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.diff.Edit;
import org.eclipse.jgit.diff.EditList;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.TreeWalk;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CoveredStatementChurnReporter extends DemographicReporter {
	public static boolean VERBOSE = false;

	public CoveredStatementChurnReporter(String outputFile) {
		super(outputFile);
	}
	private static HashMap<String, FileChurn> churnMap;

	private static String output(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + System.getProperty("line.separator"));
			}
		} finally {
		    if(br != null) {
				br.close();
			}
		}
		return sb.toString();
	}

	private static String systemCall(List<String> command) throws IOException {
		String output = "";
		// public static void main (String[]args) throws InterruptedException,
		// IOException {
		ProcessBuilder pb = new ProcessBuilder(command);
		if (VERBOSE) {
			System.out.println("Run ");
			for (String s : command) {
				System.out.print(s + " ");
			}
		}
		Process process = null;
		try {
			process = pb.start();
			output = output(process.getInputStream());

			boolean exited = process.waitFor(30, TimeUnit.SECONDS);
			int errCode = -1;
			if (!exited) {
				process.destroyForcibly();
				System.out.println("Process timed out");
			} else
				errCode = process.exitValue();
			if (VERBOSE)
				System.out.println("Echo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
			if (errCode != 0) {
				System.out.println("Tried to run ");
				for (String s : command) {
					System.out.print(s + " ");
				}
				System.out.println("Error code was " + errCode);
				throw new IOException("Unable to read result of call");
			}
			// System.out.println("Echo Output:\n" + output);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return output;
		// }
	}

	@Override
	public void getDemographicResults(Collection<TestContext> tests, MavenProject project, Repository repo, String rootProjectName) throws IOException {
		//First: calculate churn of each statement in the repo currently.

		Ref head = repo.findRef("HEAD");
		if (head == null) {
			System.err.println("Warning: invalid git directory!");
			return;
		}
		// a RevWalk allows to walk over commits based on some filtering that is defined
		RevWalk walk = new RevWalk(repo);
		if (walk == null) {
			System.err.println("Warning: invalid git directory!");
			return;
		}
		RevCommit commit = walk.parseCommit(head.getObjectId());
		RevTree tree = commit.getTree();

		//List all files
		TreeWalk treeWalk = new TreeWalk(repo);
		treeWalk.addTree(tree);
		treeWalk.setRecursive(true);
		int[] changedLinesByPeriod = new int[TestChurnCoverage.PERIODS.length];
		if(churnMap == null) {
			//Look for existing churn map
			File cachedFile = new File(repo.getDirectory().getParent(), "churnCache");
			churnMap = new HashMap<>();
			if (cachedFile.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cachedFile));
				try {
					churnMap = (HashMap<String, FileChurn>) ois.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				ois.close();
			} else {

				while (treeWalk.next()) {
					if (treeWalk.getPathString().endsWith(".java")) {
						churnMap.put(new File(treeWalk.getPathString()).getAbsolutePath(), new FileChurn());
					}
				}
				treeWalk.close();

				Git git = new Git(repo);
				LogCommand log = git.log();
				log.add(repo.resolve("HEAD"));
				try {
					CanonicalTreeParser thisCommParser = new CanonicalTreeParser();
					ObjectReader reader = repo.newObjectReader();
					RevWalk revWalk = new RevWalk(repo);
					int numCommitsBack = 0;
					for (RevCommit c : log.call()) {
						numCommitsBack++;
						if (c.getParentCount() == 0) {
							//This is the first commit
							thisCommParser.reset(reader, c.getTree());
							CanonicalTreeParser parentParser = new CanonicalTreeParser();
//					parentParser.reset(reader, p.getTree());
							DiffFormatter f = new DiffFormatter(System.out);
							f.setRepository(repo);
							List<DiffEntry> entries = f.scan(parentParser, thisCommParser);
							for (DiffEntry diff : entries) {
								if (diff.getNewPath() != null) {
									String absPath = new File(diff.getNewPath()).getAbsolutePath();
									FileChurn churn = churnMap.get(absPath);
									if (churn != null) {
										EditList el = f.toFileHeader(diff).toEditList();
										if (!el.isEmpty()) {
											churn.accumulate(repo, diff.getNewPath(), tree, c.getTree(), reader, c, el, numCommitsBack);
										}
									}
								}
							}
						}
						for (int parentIndex = 0; parentIndex < c.getParentCount(); parentIndex++) {
							RevCommit parent = c.getParent(parentIndex);
							RevCommit p = parent;
							thisCommParser.reset(reader, c.getTree());
							p = revWalk.parseCommit(p.getId());
							CanonicalTreeParser parentParser = new CanonicalTreeParser();
							parentParser.reset(reader, p.getTree());
							DiffFormatter f = new DiffFormatter(System.out);
							f.setRepository(repo);
							List<DiffEntry> entries = f.scan(parentParser, thisCommParser);
							for (DiffEntry diff : entries) {
								if (diff.getNewPath() != null) {
									String absPath = new File(diff.getNewPath()).getAbsolutePath();
									FileChurn churn = churnMap.get(absPath);
									if (churn != null) {
										EditList el = f.toFileHeader(diff).toEditList();
										if (!el.isEmpty()) {
											churn.accumulate(repo, diff.getNewPath(), tree, c.getTree(), reader, c, el, numCommitsBack);
										}
									}
								}
							}
						}
					}
				} catch (GitAPIException e) {
					e.printStackTrace();
					throw new IOException(e);
				}
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cachedFile));
				oos.writeObject(churnMap);
				oos.close();
			}
		}

		for (FileChurn eachFile : churnMap.values()) {
			for (LineChurn eachLine : eachFile.lines) {
				if (eachLine != null)
					for (int i = 0; i < TestChurnCoverage.PERIODS.length; i++)
						if (eachLine.modifyingCommittersByPeriod.get(TestChurnCoverage.PERIODS[i]).size() > 0)
							changedLinesByPeriod[i]++;
			}
		}
		int successes = 0;
		output.print("project,test,");
		TestChurnCoverage.formatHeader(output);
		output.print('\n');
		for (TestContext test : tests) {
			TestChurnCoverage churnThisTest = new TestChurnCoverage();
			churnThisTest.setTotalChangedLines(changedLinesByPeriod);
			for (Map.Entry<String, HashSet<Integer>> each : test.getCoveredClassesAndTheirLines().entrySet()) {
				String classFileName = each.getKey();
				String sourceFile = test.getJdtContext().getDefiningSourceFile(classFileName);
				if (sourceFile != null) //source file will be null for library classes
				{
					sourceFile = new File(sourceFile).getAbsolutePath();
					FileChurn churnThisFile = churnMap.get(sourceFile);
					if (churnThisFile != null) {
						churnThisTest.projectSourceClassesCovered++;
						for (Integer i : each.getValue()) //for each covered statement in this test/class
						{
							if (i < churnThisFile.lines.size()) {
								LineChurn churn = churnThisFile.lines.get(i);
								if (churn != null) {
									successes++;
//									System.out.println(test.getTestClassName()+"#"+test.getTestMethodName()+"->"+sourceFile+"#"+i);
									churnThisTest.accumulate(churn);
								}
							}
						}
					}
				}
			}
			output.print(rootProjectName);
			output.print(',');
			output.print(Utils.escapeStrForOutput(test.getTestClassName()));
			output.print('#');
			output.print(Utils.escapeStrForOutput(test.getTestMethodName()));
			output.print(',');
			churnThisTest.format(output);
			output.print('\n');
		}
		System.out.println("Demographics reporter examined " + successes + " test-statement pairs");
	}

	static class TestChurnCoverage {

		static int[] PERIODS = {5, 10, 25, 50, 75, 100, 500, 10000};
		int projectSourceLinesCovered;
		int projectSourceClassesCovered;
		int[] maxTimesACoveredLineWasModified = new int[PERIODS.length];
		int[] maxNumberCommittersACoveredLineHas = new int[PERIODS.length];
		int[][] numberOfLinesWithThisManyModificationsByPeriod = new int[PERIODS.length][200];
		private int[] sumCoveredLineModifications = new int[PERIODS.length];

		//map from line # to number of modifications, by period
		private int[] sumCoveredLineCommitters = new int[PERIODS.length];

		public static void formatHeader(PrintWriter output) {
			output.print("projectSourceLinesCovered,projectSourceClassesCovered");
			for (int i : PERIODS)
				output.print(",avgModificationsPerCoveredLine_window" + i + ",maxModificationsPerCoveredLine_window" + i + ",hIndexModificationsPerCoveredLine_window" + i + ",avgAuthorsPerCoveredLine_window" + i + ",maxAuthorsPerCoveredLine_window" + i+",percentOfModificationsCoveredByTest_window"+i);
		}

		public void accumulate(LineChurn churn) {
			projectSourceLinesCovered++;
			for (int i = 0; i < PERIODS.length; i++) {
				int numRevisionsBack = PERIODS[i];
				int modificationsThisPeriod = churn.modifyingCommittersByPeriod.get(numRevisionsBack).size();
				if(modificationsThisPeriod < numberOfLinesWithThisManyModificationsByPeriod[i].length) //if this is > 200 we have a different problem...
					numberOfLinesWithThisManyModificationsByPeriod[i][modificationsThisPeriod]++;
				if(modificationsThisPeriod > 0)
					coveredChangedLinesByPeriod[i]++;
				sumCoveredLineModifications[i] += modificationsThisPeriod;

				if (churn.modifyingCommittersByPeriod.get(numRevisionsBack).size() > maxTimesACoveredLineWasModified[i])
					maxTimesACoveredLineWasModified[i] = churn.modifyingCommittersByPeriod.get(numRevisionsBack).size();

				HashSet<String> authors = churn.getAuthors(numRevisionsBack);
				sumCoveredLineCommitters[i] += authors.size();
				if (authors.size() > maxNumberCommittersACoveredLineHas[i])
					maxNumberCommittersACoveredLineHas[i] = authors.size();
			}
		}

		public void format(PrintWriter output) {
			output.print(projectSourceLinesCovered);
			output.print(',');

			output.print(projectSourceClassesCovered);

			for (int i = 0; i < PERIODS.length; i++) {
				output.print(',');
				if (projectSourceLinesCovered > 0)
					output.print(((double) sumCoveredLineModifications[i]) / projectSourceLinesCovered);
				else
					output.print(0);
				output.print(',');

				output.print(maxTimesACoveredLineWasModified[i]);
				output.print(',');

				//Calculate H-index
				int hIndexModifications = 0;
				for (int j = 0; j < numberOfLinesWithThisManyModificationsByPeriod[i].length; j++) {
					if (j > hIndexModifications && numberOfLinesWithThisManyModificationsByPeriod[i][j] >= j)
						hIndexModifications = j;
				}
				output.print(hIndexModifications);
				output.print(',');


				if (projectSourceLinesCovered > 0)
					output.print(((double) sumCoveredLineCommitters[i]) / projectSourceLinesCovered);
				else
					output.print(0);
				output.print(',');
				output.print(maxNumberCommittersACoveredLineHas[i]);

				output.print(',');
				output.print(100*((double) coveredChangedLinesByPeriod[i])/changedLinesByPeriod[i]);
			}
		}

		private int[] changedLinesByPeriod;
		private int[] coveredChangedLinesByPeriod;

		public void setTotalChangedLines(int[] changedLinesByPeriod) {
			this.changedLinesByPeriod = changedLinesByPeriod;
			this.coveredChangedLinesByPeriod = new int[changedLinesByPeriod.length];
		}
	}

	static class FileChurn implements Serializable {
		public static final long serialVersionUID = -4373317424055523325L;

		private ArrayList<LineChurn> lines = new ArrayList<>();

		public void accumulate(Repository repo, String modifiedFile, RevTree nowCommitTree, RevTree thisCommitTree, ObjectReader reader, RevCommit c, EditList el, int numCommitsBack) {
			HashMap<Integer, Integer> lineOffsets = new HashMap<>();
			try (TreeWalk treeWalk = TreeWalk.forPath(repo, modifiedFile, nowCommitTree, thisCommitTree)) {
				byte[] data = reader.open(treeWalk.getObjectId(0)).getBytes();
				byte[] dataOld = reader.open(treeWalk.getObjectId(1)).getBytes();
				File newTmp = File.createTempFile("linematcher", "newFile");
				File oldTmp = File.createTempFile("linematcher", "oldFile");
				// File newTmp = new File("new");
				// File oldTmp = new File("old");
				FileOutputStream fos = new FileOutputStream(newTmp);
				fos.write(data);
				fos.close();
				fos = new FileOutputStream(oldTmp);
				fos.write(dataOld);
				fos.close();

				String diff1 = systemCall(Arrays.asList("/bin/bash", "-c", "diff --unchanged-line-format=\"%dn,%c'\\12'\" --new-line-format=\"n%c'\\12'\" --old-line-format=\"\"  " + newTmp.getAbsolutePath() + " " + oldTmp.getAbsolutePath() + " | awk '/,/{n++;print $0n} /n/{n++}'"));
				String[] offsetStrings = diff1.split("\n");
				newTmp.delete();
				oldTmp.delete();
				for (String offset : offsetStrings) {
					String[] offsetSplit = offset.split(",");
					try {
						if (offsetSplit.length == 2)
							lineOffsets.put(Integer.parseInt(offsetSplit[1]), Integer.parseInt(offsetSplit[0]));
					} catch (NumberFormatException ex) {
						// Random other lines show up here,
						// f that
					}
				}
			} catch (IncorrectObjectTypeException e) {
				e.printStackTrace();
			} catch (CorruptObjectException e) {
				e.printStackTrace();
			} catch (MissingObjectException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			HashSet<Integer> changedLines = new HashSet<>();
			for (Edit e : el) {
				for (int i = e.getBeginB() + 1; i <= e.getEndB(); i++) {
					//Now: need to remap line 'i' to where it lives *currently*
					Integer j = lineOffsets.get(i);
					if (j == null)
						j = i;
					changedLines.add(j);
					touchLine(j, c, numCommitsBack);
				}
			}
		}

		private void touchLine(int i, RevCommit c, int numCommitsBack) {
			ensureSize(i);
			LineChurn line = lines.get(i);
			if (line == null) {
				line = new LineChurn();
				lines.set(i, line);
			}
			line.addModifier(c, numCommitsBack);
		}

		@Override
		public String toString() {
			StringBuilder linesStr = new StringBuilder();
			for (int i = 0; i < lines.size(); i++) {
				linesStr.append(i);
				linesStr.append(':');
				linesStr.append(lines.get(i));
				linesStr.append(", ");
			}
			return "FileChurn{" +
					"lines=" + linesStr.toString() +
					'}';
		}

		private void ensureSize(int i) {
			while (i >= lines.size())
				lines.add(null);
		}
	}

	static class LineChurn implements Serializable {


		public static final long serialVersionUID = 2746304277381305596L;
		HashMap<Integer, LinkedList<String>> modifyingCommittersByPeriod;

		public LineChurn() {
			modifyingCommittersByPeriod = new HashMap<>();
			for (int i : TestChurnCoverage.PERIODS) {
				modifyingCommittersByPeriod.put(i, new LinkedList<String>());
			}
		}

		@Override
		public String toString() {
			return "LineChurn{" +
					"modifyingCommits=" + modifyingCommittersByPeriod +
					'}';
		}

		public void addModifier(RevCommit c, int numCommitsBack) {
			for (Map.Entry<Integer, LinkedList<String>> each : modifyingCommittersByPeriod.entrySet())
				if (each.getKey() > numCommitsBack)
					each.getValue().add(c.getAuthorIdent().getEmailAddress());
		}

		public HashSet<String> getAuthors(int period) {
			HashSet<String> ret = new HashSet<>();
			for (String c : modifyingCommittersByPeriod.get(period)) {
				ret.add(c);
			}
			return ret;
		}
	}
}
