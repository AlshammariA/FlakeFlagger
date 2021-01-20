package edu.gmu.swe.smells.test.faketests;

import edu.gmu.swe.smells.test.fakeproduction.Eager;

public class EagerTest {
    public static void testNotEager() {
        Eager.method1();
    }

    public static void testEager() {
        Eager.method1();
        Eager.method2();
    }

    public static void testEagerNonStatic(){
        Eager e = new Eager();
        e.nonStaticMethod1();
        e.nonStaticMethod2();
    }

    public static void testNotEagerNonStatic(){
        Eager e = new Eager();
        e.nonStaticMethod1();
    }
}
