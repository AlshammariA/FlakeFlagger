package edu.gmu.swe.smells.test.faketests;

import edu.gmu.swe.smells.test.fakeproduction.Conditional;

public class ConditionalTest {
    public static void testNoConditional() {
        Conditional.doSomething();
    }

    public static void testConditional() {
        if(true) {
            Conditional.doSomething();
        }
    }
}
