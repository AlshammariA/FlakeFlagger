package edu.gmu.swe.smells.test.faketests;

import java.io.File;
import java.io.IOException;

import edu.gmu.swe.smells.test.fakeproduction.IndirectlyResourceOptimism;
public class ResourceOptimism {
	File ResourceOptimismDirectory;
	protected void setUp() throws IOException{
		ResourceOptimismDirectory = new File("/newTempPath");
	    if (! ResourceOptimismDirectory.exists()){
	    	ResourceOptimismDirectory.mkdir();
	    }
	}
	public void testResourceOptimismIndirectly() throws InterruptedException, IOException {
		IndirectlyResourceOptimism.resourceOptimism();
	}

	public void testResourceOptimismDirectly() throws InterruptedException, IOException {
		File outputFile = File.createTempFile("image", "png", new File("/newtemp"));
		}

}
