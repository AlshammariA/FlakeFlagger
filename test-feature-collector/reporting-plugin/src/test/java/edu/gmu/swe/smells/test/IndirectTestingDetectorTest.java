package edu.gmu.swe.smells.test;

import edu.gmu.swe.smells.detector.IndirectTestingDetector;
import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.DetectedSmellInstance;
import edu.gmu.swe.smells.test.fakeproduction.DirectTarget;
import edu.gmu.swe.smells.test.fakeproduction.Eager;
import edu.gmu.swe.smells.test.faketests.DirectTargetTest;
import edu.gmu.swe.smells.test.faketests.EagerTest;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

import static edu.gmu.swe.smells.test.BaseSmellDetectorTest.toInternalName;

public class IndirectTestingDetectorTest extends BaseSmellDetectorTest{
    @Test
    public void testDirectTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(IndirectTestingDetector.class);

        addCoveredLine(toInternalName(DirectTargetTest.class), "testDirect", toInternalName(DirectTargetTest.class), 7, 8, 9);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) DirectTargetTest.class),
                Collections.singletonList((Class) DirectTarget.class), detectors);

        verifyNoSmell(result);
    }
    @Test
    public void testIndirectTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(IndirectTestingDetector.class);

        addCoveredLine(toInternalName(DirectTargetTest.class), "testIndirect", toInternalName(DirectTargetTest.class), 10, 11, 12, 13);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) DirectTargetTest.class),
                Collections.singletonList((Class) DirectTarget.class), detectors);

        verifySmells(result, IndirectTestingDetector.KEY);
    }
    @Test
    public void testIndirectTest2() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(IndirectTestingDetector.class);

        addCoveredLine(toInternalName(DirectTargetTest.class), "testIndirect2", toInternalName(DirectTargetTest.class), 14, 15, 16);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) DirectTargetTest.class),
                Collections.singletonList((Class) DirectTarget.class), detectors);

        verifySmells(result, IndirectTestingDetector.KEY);
    }

    @Test
    public void testIndirectIndirectTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(IndirectTestingDetector.class);

        addCoveredLine(toInternalName(DirectTargetTest.class), "testIndirectIndirect", toInternalName(DirectTargetTest.class), 18, 19, 20, 10, 11, 12, 13);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) DirectTargetTest.class),
                Collections.singletonList((Class) DirectTarget.class), detectors);

        verifySmells(result, IndirectTestingDetector.KEY);
    }

    @Test
    public void testIndirectDirectTest() {
        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(IndirectTestingDetector.class);

        addCoveredLine(toInternalName(DirectTargetTest.class), "testIndirectDirect", toInternalName(DirectTargetTest.class), 22, 23, 24, 7, 8, 9);

        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) DirectTargetTest.class),
                Collections.singletonList((Class) DirectTarget.class), detectors);

        verifyNoSmell(result);
    }

    @Test
    public void testIndirectOnlyConsidersTestClassCode() {

        LinkedList<Class<? extends AbstractTestSmellDetector>> detectors = new LinkedList<>();
        detectors.add(IndirectTestingDetector.class);

        addCoveredLine(toInternalName(DirectTargetTest.class), "testIndirectDirect", toInternalName(DirectTargetTest.class), 22, 23, 24, 7, 8, 9);

        addCoveredLine(toInternalName(DirectTargetTest.class), "testIndirectDirect", toInternalName(EagerTest.class), 15, 16, 17, 18);
        LinkedList<Class> listOfCoveredClasses = new LinkedList<>();
        listOfCoveredClasses.add(DirectTarget.class);
        listOfCoveredClasses.add(EagerTest.class);
        LinkedList<DetectedSmellInstance> result = doTestsHaveSmells(Collections.singletonList((Class) DirectTargetTest.class),
                listOfCoveredClasses, detectors);

        verifyNoSmell(result);

    }

}
