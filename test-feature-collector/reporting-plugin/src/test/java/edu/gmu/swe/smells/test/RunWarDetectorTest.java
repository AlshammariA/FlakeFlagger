package edu.gmu.swe.smells.test;

import edu.gmu.swe.smells.detector.RunWarDetector;
import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.test.fakeproduction.RunWar;
import edu.gmu.swe.smells.test.faketests.RunWarTest;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

public class RunWarDetectorTest extends BaseSmellDetectorTest{


    @Test
    public void testNoRunWarTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(RunWarDetector.class);

        addCoveredLine(toInternalName(RunWarTest.class), "testNoRunWar", toInternalName(RunWarTest.class), 11, 12, 13);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) RunWarTest.class),
                Collections.singletonList((Class) RunWar.class), detectors);

        verifyNoSmell(result);
    }

    @Test
    public void testSameFileTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(RunWarDetector.class);

        addCoveredLine(toInternalName(RunWarTest.class), "testSameFile1", toInternalName(RunWarTest.class), 14, 15, 16, 17);
        addCoveredLine(toInternalName(RunWarTest.class), "testSameFile2", toInternalName(RunWarTest.class), 18, 19, 20, 21);
        addCoveredLine(toInternalName(RunWarTest.class), "testNotSameFile", toInternalName(RunWarTest.class), 22, 23, 24, 25);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) RunWarTest.class),
                Collections.singletonList((Class) RunWar.class), detectors);

        verifySmells(result, RunWarDetector.KEY, RunWarDetector.KEY);
    }

    @Test
    public void testStaticFieldTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(RunWarDetector.class);

        addCoveredLine(toInternalName(RunWarTest.class), "testStaticField", toInternalName(RunWarTest.class), 26, 27, 28, 29);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) RunWarTest.class),
                Collections.singletonList((Class) RunWar.class), detectors);

        verifySmells(result, RunWarDetector.KEY);
    }

    @Test
    public void testStaticFinalFieldTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(RunWarDetector.class);

        addCoveredLine(toInternalName(RunWarTest.class), "testStaticFinalField", toInternalName(RunWarTest.class), 30, 31, 32);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) RunWarTest.class),
                Collections.singletonList((Class) RunWar.class), detectors);

        verifyNoSmell(result);
    }
}
