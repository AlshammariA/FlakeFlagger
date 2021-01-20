package edu.gmu.swe.kp.report.jacoco;

import java.util.HashSet;

public interface SessionCoverageVisitor {
	public void preVisitClass(String probeClass);

	public void preVisitMethod(String probeClass, String probeMethod);

	public void visitCoverage(String testClassName, String testMethodName, String probeClass, HashSet<Integer> coveredLines, int totalLines, int nInsncovered, int nInsnTotal, int diffLinesCovered, int nDiffLinesTotal);

	public void endVisitMethod(String probeClass, String probeMethod, int nCoveredLines, int nTotalLines, int nInsncovered, int nInsnTotal, int diffLinesCovered, int nDiffLinesTotal);

	public void postVisitClass(String name);
}
