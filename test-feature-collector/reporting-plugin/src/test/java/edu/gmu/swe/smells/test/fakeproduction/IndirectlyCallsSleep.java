package edu.gmu.swe.smells.test.fakeproduction;

public class IndirectlyCallsSleep {
	public static void callsSleep() throws InterruptedException {
		Thread.sleep(1000);
	}
}
