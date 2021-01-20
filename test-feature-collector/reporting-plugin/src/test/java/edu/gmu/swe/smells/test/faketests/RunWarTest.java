package edu.gmu.swe.smells.test.faketests;

import edu.gmu.swe.smells.test.fakeproduction.RunWar;
import org.junit.Test;

import java.io.File;

public class RunWarTest {
    public static int notFinal = 0;
    public static final int isFinal = 0;

    public static void testNoRunWar() {
        RunWar.method(0);
    }

    public static void testSameFile1() {
        File file;
        file = new File("testFile1.txt");
        RunWar.method(0);
    }

    public static void testSameFile2() {
        File file = new File("testFile1.txt");
        RunWar.method(0);
    }

    public static void testNotSameFile() {
        File file = new File("testFile2.txt");
        RunWar.method(0);
    }

    public static void testStaticField() {
        notFinal += 1;
        RunWar.method(notFinal);
    }

    public static void testStaticFinalField() {
        RunWar.method(isFinal);
    }
}