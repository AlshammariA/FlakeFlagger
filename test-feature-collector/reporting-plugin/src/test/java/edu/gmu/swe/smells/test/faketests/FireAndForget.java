package edu.gmu.swe.smells.test.faketests;

import edu.gmu.swe.smells.test.fakeproduction.IndirectlyFireAndForget;

public class FireAndForget {
	public void testFireAndForgetIndirectly() throws InterruptedException {
		IndirectlyFireAndForget.fire();
	}

	public void testFireAndForgetDirectly() throws InterruptedException {
		Thread.yield();
	}

}
