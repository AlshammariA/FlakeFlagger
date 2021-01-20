package edu.gmu.swe.smells.coverage;

import edu.gmu.swe.kp.report.jacoco.SessionCoverageVisitor;

public interface CoverageSource {
	public void visitCoverage(SessionCoverageVisitor coverageVisitor);
}
