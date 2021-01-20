package edu.gmu.swe.smells.test.fakeproduction;

public class IndirectlyFireAndForget {
	public static void fire() throws InterruptedException {
		Thread.yield();
	}
}
