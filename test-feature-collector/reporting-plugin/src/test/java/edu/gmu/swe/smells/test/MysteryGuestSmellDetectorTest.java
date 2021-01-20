package edu.gmu.swe.smells.test;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.MysteryGuestSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.test.fakeproduction.IndirectlyMysteryGuest;
import edu.gmu.swe.smells.test.faketests.MysteryGuest;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class MysteryGuestSmellDetectorTest extends BaseSmellDetectorTest {
	@Test
	public void testMysteryGuestDirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(MysteryGuestSmellDetector.class);

		addCoveredLine(toInternalName(MysteryGuest.class), "testMysteryGuestFileDirectly", toInternalName(MysteryGuest.class), 16, 17, 18);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) MysteryGuest.class),
				Collections.singletonList((Class) IndirectlyMysteryGuest.class), detectors);
		verifySmells(result, MysteryGuestSmellDetector.KEY);
	}

	@Test
	public void testMysteryGuestIndirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(MysteryGuestSmellDetector.class);

		addCoveredLine(toInternalName(MysteryGuest.class), "testMysteryGuestFileIndirectly", toInternalName(IndirectlyMysteryGuest.class), 10, 11, 12);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) MysteryGuest.class),
				Collections.singletonList((Class) IndirectlyMysteryGuest.class), detectors);
		verifySmells(result, MysteryGuestSmellDetector.KEY);
	}
	@Test
	public void testMysteryGuestDatabaseDirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(MysteryGuestSmellDetector.class);

		addCoveredLine(toInternalName(MysteryGuest.class), "testMysteryGuestDatabaseDirectly", toInternalName(MysteryGuest.class), 24, 25, 26);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) MysteryGuest.class),
				Collections.singletonList((Class) IndirectlyMysteryGuest.class), detectors);
		verifySmells(result, MysteryGuestSmellDetector.KEY);
	}

	@Test
	public void testMysteryGuestDatabaseIndirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(MysteryGuestSmellDetector.class);

		addCoveredLine(toInternalName(MysteryGuest.class), "testMysteryGuestDatabaseIndirectly", toInternalName(IndirectlyMysteryGuest.class), 14, 15, 16);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) MysteryGuest.class),
				Collections.singletonList((Class) IndirectlyMysteryGuest.class), detectors);
		verifySmells(result, MysteryGuestSmellDetector.KEY);
	}

	@Test
	public void testMysteryGuestOnConstructors(){
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(MysteryGuestSmellDetector.class);

		addCoveredLine(toInternalName(MysteryGuest.class), "testMysteryGuestConstructors", toInternalName(MysteryGuest.class), 28, 29, 30);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) MysteryGuest.class),
				Collections.singletonList((Class) MysteryGuest.class), detectors);
		verifySmells(result, MysteryGuestSmellDetector.KEY);
	}
	/*
	@Test
	public void testMysteryGuestNetworkDirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(MysteryGuestSmellDetector.class);

		addCoveredLine(toInternalName(MysteryGuest.class), "testMysteryGuestNetworkDirectly", toInternalName(MysteryGuest.class), 32, 33, 34);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) MysteryGuest.class),
				Collections.singletonList((Class) IndirectlyMysteryGuest.class), detectors);
		verifySmells(result, MysteryGuestSmellDetector.KEY);
	}

	@Test
	public void testMysteryGuestNetworkIndirectly() {
		LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
		detectors.add(MysteryGuestSmellDetector.class);

		addCoveredLine(toInternalName(MysteryGuest.class), "testMysteryGuestNetworkIndirectly", toInternalName(IndirectlyMysteryGuest.class), 18, 19, 20);

		LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) MysteryGuest.class),
				Collections.singletonList((Class) IndirectlyMysteryGuest.class), detectors);
		verifySmells(result, MysteryGuestSmellDetector.KEY);
	}*/
}
