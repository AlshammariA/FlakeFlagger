package edu.gmu.swe.smells.test;

import edu.gmu.swe.smells.detector.AssertionRouletteDetector;
import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.test.fakeproduction.AssertionRoulette;
import edu.gmu.swe.smells.test.faketests.AssertionRouletteTest;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class AssertionRouletteDetectorTest extends BaseSmellDetectorTest {
    @Test
    public void testNoRouletteTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(AssertionRouletteDetector.class);

        addCoveredLine(toInternalName(AssertionRouletteTest.class), "testNoRoulette", toInternalName(AssertionRoulette.class), 8, 9, 10, 11);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) AssertionRouletteTest.class),
                Collections.singletonList((Class) AssertionRoulette.class), detectors);

        verifyNoSmell(result);
    }

    @Test
    public void testRouletteTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(AssertionRouletteDetector.class);

        addCoveredLine(toInternalName(AssertionRouletteTest.class), "testRoulette", toInternalName(AssertionRoulette.class), 13, 14, 15, 16, 17);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) AssertionRouletteTest.class),
                Collections.singletonList((Class) AssertionRoulette.class), detectors);

        verifySmells(result, AssertionRouletteDetector.KEY);
    }
}
