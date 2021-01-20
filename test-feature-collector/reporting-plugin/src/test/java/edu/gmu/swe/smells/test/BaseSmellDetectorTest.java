package edu.gmu.swe.smells.test;

import edu.gmu.swe.kp.report.jacoco.SessionCoverageVisitor;
import edu.gmu.swe.smells.coverage.CoverageSource;
import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.detector.internal.DetectorEntryPoint;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.junit.Assert;
import org.junit.Before;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * All of the tests should extend this class
 * @author jon
 */
public class BaseSmellDetectorTest {
	private LinkedList<MockCoverage> mockCoverages = new LinkedList<>();

	public BaseSmellDetectorTest() {

	}

	public static final String toInternalName(Class c) {
		String ret = c.getName();
		return ret.replace('.', '/');
	}

	/**
	 * Given a list of expected test smell types, will fail the test if exactly those smells are not detected.
	 *
	 * @param detectedSmells
	 * @param expectedSmells
	 */
	protected final void verifySmells(LinkedList<DetectedSmellInstance> detectedSmells, String... expectedSmells)
	{
		HashSet<String> tmp = new HashSet<>();
		if(detectedSmells.size() != expectedSmells.length)
			Assert.fail("Expected smells to be detected: " + Arrays.toString(expectedSmells) +", but actual: " + detectedSmells);
		for(DetectedSmellInstance i : detectedSmells)
			tmp.add(i.smell);
		for(String s : expectedSmells)
			if(!tmp.contains(s))
				Assert.fail("Expected smells to be detected: " + Arrays.toString(expectedSmells) +", but actual: " + detectedSmells);

	}

	protected final void verifyNoSmell(LinkedList<DetectedSmellInstance> detectedSmells) {
		for(DetectedSmellInstance i : detectedSmells)
			if(i.smell != null)
				Assert.fail("Expected no smells to be detected, but actual: " + detectedSmells);
	}
	/**
	 * Mock some coverage so that the smell detectors will work in the absence of real coverage collection
	 *
	 * @param testClass
	 * @param testName
	 * @param coveredClassName
	 * @param coveredLine
	 */
	protected final void addCoveredLine(String testClass, String testName, String coveredClassName, int... coveredLine) {
		mockCoverages.add(new MockCoverage(testClass, testName, coveredClassName, coveredLine));

	}

	@Before
	public final void reset() {
		mockCoverages = new LinkedList<>();

	}


	/**
	 * Call this method in your test case to run the smell detection process.
	 * <p>
	 * You must call addCoveredLine some number of times first in order to tell the smell detector what lines
	 * are covered. When we run this with real projects (and not these unit tests), the coverage comes automatically
	 * from JaCoCo.
	 *
	 * @param listOfTestClassFiles       Classes that we should consider to be test files
	 * @param listOfProductionClassFiles Classes that we should consider to be source files
	 * @param detectors                  List of test smell detectors to run
	 * @return Detected smells
	 */
	public final LinkedList<DetectedSmellInstance> doTestsHaveSmells(Collection<Class> listOfTestClassFiles,
	                                                               Collection<Class> listOfProductionClassFiles, Collection<Class<? extends AbstractTestSmellDetector>> detectors) {
		final File f = new File(BaseSmellDetectorTest.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getParentFile();
		Path p = f.toPath();
		p = Paths.get("").toAbsolutePath().relativize(p);
		LinkedList<String> fixedTestClasses = new LinkedList<>();
		LinkedList<String> fixedSourceClasses = new LinkedList<>();
		for (Class c : listOfProductionClassFiles)
			fixedSourceClasses.add(p.resolve("src/test/java/" + toInternalName(c) + ".java").toString());

		for (Class c : listOfTestClassFiles)
			fixedTestClasses.add(p.resolve("src/test/java/" + toInternalName(c) + ".java").toString());

		String[] sourcePath = {p.resolve("src/main/java").toString(), p.resolve("src/test/java").toString()};
		String[] classPath = {p.resolve("target/classes").toString()};

		CoverageSource fakeCoverageSource = new CoverageSource() {
			@Override
			public void visitCoverage(SessionCoverageVisitor coverageVisitor) {
				for (MockCoverage c : mockCoverages)
					c.accept(coverageVisitor);

			}
		};
		HashMap<String, TestContext> testMap = DetectorEntryPoint.buildTestContextMap(fixedSourceClasses,fixedTestClasses, sourcePath, classPath,fakeCoverageSource);
		LinkedList<DetectedSmellInstance> all = DetectorEntryPoint.detectSmells(detectors, testMap);
		LinkedList<DetectedSmellInstance> ret = new LinkedList<>();
		for (DetectedSmellInstance i : all)
			if (i.smell != null)
				ret.add(i);
		return ret;
	}

	private static class MockCoverage {
		String testClass;
		String testMethod;
		String coveredClassName;
		HashSet<Integer> coveredLines;

		public MockCoverage(String testClass, String testMethod, String coveredClassName, int[] coveredLines) {
			this.testClass = testClass.replace('/','.');
			this.testMethod = testMethod;
			this.coveredClassName = coveredClassName;
			this.coveredLines = new HashSet<>();
			for (int i : coveredLines)
				this.coveredLines.add(i);
		}

		public void accept(SessionCoverageVisitor vis) {
			vis.visitCoverage(testClass, testMethod, coveredClassName, coveredLines, 0, 0, 0, 0, 0);
		}
	}

}
