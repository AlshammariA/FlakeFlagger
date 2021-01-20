package edu.gmu.swe.smells.test;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.FireAndForgetSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.test.fakeproduction.IndirectlyFireAndForget;
import edu.gmu.swe.smells.test.faketests.FireAndForget;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class FireAndForgetSmellDetectorTest extends BaseSmellDetectorTest {
	@Test
	public void testFireAndForgetDirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(FireAndForgetSmellDetector.class);

		addCoveredLine(toInternalName(FireAndForget.class), "testFireAndForgetDirectly", toInternalName(FireAndForget.class), 10, 11, 12);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) FireAndForget.class),
				Collections.singletonList((Class) IndirectlyFireAndForget.class), detectors);
		verifySmells(result, FireAndForgetSmellDetector.KEY);
	}

	@Test
	public void testFireAndForgetIndirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(FireAndForgetSmellDetector.class);

		addCoveredLine(toInternalName(FireAndForget.class), "testFireAndForgetIndirectly", toInternalName(IndirectlyFireAndForget.class), 4, 5, 6);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) FireAndForget.class),
				Collections.singletonList((Class) IndirectlyFireAndForget.class), detectors);

		verifySmells(result, FireAndForgetSmellDetector.KEY);
	}
}
