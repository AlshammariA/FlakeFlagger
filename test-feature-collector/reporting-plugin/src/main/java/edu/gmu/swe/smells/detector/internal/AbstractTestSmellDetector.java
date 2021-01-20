package edu.gmu.swe.smells.detector.internal;

import java.util.Collection;

public abstract class AbstractTestSmellDetector {

	/**
	 * Given a TestContext, report on whether this test has this detector's smell
	 *
	 * @param test
	 * @return
	 */
	public abstract boolean checkForSmell(TestContext test, Collection<TestContext> otherContexts);

	/**
	 * Return the name of the smell that this detector checks for (for reporting)
	 *
	 * @return
	 */
	public abstract String getName();


}
