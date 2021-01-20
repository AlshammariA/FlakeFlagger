package edu.gmu.swe.smells.test.faketests;

import edu.gmu.swe.smells.test.fakeproduction.AssertionRoulette;

import static org.junit.Assert.assertEquals;

public class AssertionRouletteTest {
    public static void testNoRoulette() {
        int res = AssertionRoulette.method();
        assertEquals(res, 42);
    }

    public static void testRoulette() {
        int res = AssertionRoulette.method();
        assertEquals(res, 42);
        assertEquals(res/6, 7);
    }
}
