package edu.gmu.swe.smells.test.fakeproduction;

import java.io.File;
import java.io.IOException;

public class IndirectlyResourceOptimism {
	public static void resourceOptimism() throws InterruptedException, IOException {
		File file = File.createTempFile("image", "png", new File("/tmp"));
	}
}
