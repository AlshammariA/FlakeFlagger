package edu.gmu.swe.smells.test;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.CallsSleepSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.test.fakeproduction.IndirectlyCallsSleep;
import edu.gmu.swe.smells.test.faketests.CallsSleep;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class CallsSleepSmellDetectorTest extends BaseSmellDetectorTest {
	@Test
	public void testCallsSleepDirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(CallsSleepSmellDetector.class);

		addCoveredLine(toInternalName(CallsSleep.class), "testCallsSleepDirectly", toInternalName(CallsSleep.class), 10, 11, 12);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) CallsSleep.class),
				Collections.singletonList((Class) IndirectlyCallsSleep.class), detectors);

		verifySmells(result, CallsSleepSmellDetector.KEY);
	}

	@Test
	public void testCallsSleepIndirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(CallsSleepSmellDetector.class);

		addCoveredLine(toInternalName(CallsSleep.class), "testCallsSleepIndirectly", toInternalName(IndirectlyCallsSleep.class), 4, 5, 6);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) CallsSleep.class),
				Collections.singletonList((Class) IndirectlyCallsSleep.class), detectors);

		verifySmells(result, CallsSleepSmellDetector.KEY);
	}
}
