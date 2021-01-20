package edu.gmu.swe.smells.test.faketests;

import edu.gmu.swe.smells.test.fakeproduction.IndirectlyCallsSleep;

public class CallsSleep {
	public void testCallsSleepIndirectly() throws InterruptedException {
		IndirectlyCallsSleep.callsSleep();
	}

	public void testCallsSleepDirectly() throws InterruptedException {
		Thread.sleep(1000);
	}

}
