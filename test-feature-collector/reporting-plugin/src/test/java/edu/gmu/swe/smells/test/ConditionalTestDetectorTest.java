package edu.gmu.swe.smells.test;

import edu.gmu.swe.smells.detector.ConditionalTestDetector;
import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.test.fakeproduction.Conditional;
import edu.gmu.swe.smells.test.faketests.ConditionalTest;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class ConditionalTestDetectorTest extends BaseSmellDetectorTest {
    @Test
    public void testNoConditionalTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(ConditionalTestDetector.class);

        addCoveredLine(toInternalName(ConditionalTest.class), "testNoConditional", toInternalName(ConditionalTest.class), 6, 7, 8);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) ConditionalTest.class),
                Collections.singletonList((Class) Conditional.class), detectors);

        verifyNoSmell(result);
    }

    @Test
    public void testConditionalTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(ConditionalTestDetector.class);

        addCoveredLine(toInternalName(ConditionalTest.class), "testConditional", toInternalName(ConditionalTest.class), 10, 11, 12, 13, 14);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) ConditionalTest.class),
                Collections.singletonList((Class) Conditional.class), detectors);

        verifySmells(result, ConditionalTestDetector.KEY);
    }
}
