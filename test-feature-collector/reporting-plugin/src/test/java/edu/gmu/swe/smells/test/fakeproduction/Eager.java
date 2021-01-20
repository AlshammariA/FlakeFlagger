package edu.gmu.swe.smells.test.fakeproduction;

public class Eager {
    public static void method1() {
        System.out.println("Eager test method 1");
    }

    public static void method2() {
        System.out.println("Eager test method 2");
    }

    public void nonStaticMethod1(){
        System.out.println("Eager non static method 1");
    }

    public void nonStaticMethod2(){
        System.out.println("Eager non static method 2");
    }
}
