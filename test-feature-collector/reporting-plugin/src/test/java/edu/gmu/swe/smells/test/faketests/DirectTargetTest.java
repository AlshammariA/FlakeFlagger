package edu.gmu.swe.smells.test.faketests;

import edu.gmu.swe.smells.test.fakeproduction.DirectTarget;
import edu.gmu.swe.smells.test.fakeproduction.IndirectTarget;

public class DirectTargetTest {
    public static void testDirect() {
        DirectTarget.directTest();
    }
    public static void testIndirect() {
        DirectTarget.directTest();
        IndirectTarget.indirectTest();
    }
    public static void testIndirect2() {
        IndirectTarget.indirectTest();
    }

    public static void testIndirectIndirect(){
        testIndirect();
    }

    public static void testIndirectDirect() {
        testDirect();
    }
}
