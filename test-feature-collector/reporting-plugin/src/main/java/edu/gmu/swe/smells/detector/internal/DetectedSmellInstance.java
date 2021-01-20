package edu.gmu.swe.smells.detector.internal;

public class DetectedSmellInstance {
	public String smell;
	public TestContext test;

	public DetectedSmellInstance(String smell, TestContext test) {
		this.smell = smell;
		this.test = test;
	}

	@Override
	public String toString() {
		return "DetectedSmellInstance{" +
				"smell='" + smell + '\'' +
				", test=" + test +
				'}';
	}
}
