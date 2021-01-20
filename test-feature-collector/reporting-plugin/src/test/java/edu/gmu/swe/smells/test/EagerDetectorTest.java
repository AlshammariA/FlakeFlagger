package edu.gmu.swe.smells.test;

import edu.gmu.swe.smells.detector.EagerDetector;
import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.test.fakeproduction.Eager;
import edu.gmu.swe.smells.test.faketests.EagerTest;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class EagerDetectorTest extends BaseSmellDetectorTest{
    @Test
    public void testNotEagerTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(EagerDetector.class);

        addCoveredLine(toInternalName(EagerTest.class), "testNotEager", toInternalName(Eager.class), 6, 7, 8);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) EagerTest.class),
                Collections.singletonList((Class) Eager.class), detectors);

        verifyNoSmell(result);
    }

    @Test
    public void testEagerTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(EagerDetector.class);

        addCoveredLine(toInternalName(EagerTest.class), "testEager", toInternalName(Eager.class), 10, 11, 12, 13);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) EagerTest.class),
                Collections.singletonList((Class) Eager.class), detectors);

        verifySmells(result, EagerDetector.KEY);
    }
    @Test
    public void testNonStaticEagerTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(EagerDetector.class);

        addCoveredLine(toInternalName(EagerTest.class), "testEagerNonStatic", toInternalName(Eager.class), 10, 11, 12, 13);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) EagerTest.class),
                Collections.singletonList((Class) Eager.class), detectors);

        verifySmells(result, EagerDetector.KEY);
    }
    @Test
    public void testNonStaticNonEagerTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(EagerDetector.class);

        addCoveredLine(toInternalName(EagerTest.class), "testNotEagerNonStatic", toInternalName(Eager.class), 10, 11, 12, 13);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) EagerTest.class),
                Collections.singletonList((Class) Eager.class), detectors);

        verifyNoSmell(result);
    }
}
