package edu.gmu.swe.kp.report.jacoco;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.ICoverageVisitor;
import org.jacoco.core.data.ExecutionDataStore;
import org.objectweb.asm.ClassReader;

public class TolerantAnalyzer extends Analyzer {

	private JSONFormatter vis;

	public TolerantAnalyzer(ExecutionDataStore executionData, ICoverageVisitor coverageVisitor, JSONFormatter vis) {
		super(executionData, coverageVisitor);
		this.vis = vis;
	}

	public void analyzeClass(final ClassReader reader) {
		try {
			super.analyzeClass(reader);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
