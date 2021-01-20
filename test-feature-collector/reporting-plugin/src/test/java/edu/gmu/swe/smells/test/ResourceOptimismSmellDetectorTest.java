package edu.gmu.swe.smells.test;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.ResourceOptimismSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.test.fakeproduction.IndirectlyResourceOptimism;
import edu.gmu.swe.smells.test.faketests.ResourceOptimism;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class ResourceOptimismSmellDetectorTest extends BaseSmellDetectorTest {
	
	@Test
	public void testResourceOptimismDirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(ResourceOptimismSmellDetector.class);

		addCoveredLine(toInternalName(ResourceOptimism.class), "testResourceOptimismDirectly", toInternalName(ResourceOptimism.class), 19, 20, 21);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) ResourceOptimism.class),
				Collections.singletonList((Class) IndirectlyResourceOptimism.class), detectors);
				
		verifySmells(result, ResourceOptimismSmellDetector.KEY);
	}

	@Test
	public void testResourceOptimismIndirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(ResourceOptimismSmellDetector.class);

		addCoveredLine(toInternalName(ResourceOptimism.class), "testResourceOptimismIndirectly", toInternalName(IndirectlyResourceOptimism.class), 7, 8, 9);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) ResourceOptimism.class),
				Collections.singletonList((Class) IndirectlyResourceOptimism.class), detectors);

		verifySmells(result, ResourceOptimismSmellDetector.KEY);
	}
}
