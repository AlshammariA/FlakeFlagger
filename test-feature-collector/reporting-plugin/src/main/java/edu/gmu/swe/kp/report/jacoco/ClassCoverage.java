package edu.gmu.swe.kp.report.jacoco;

import java.util.HashMap;
import java.util.HashSet;

public class ClassCoverage {
	public HashMap<Integer, HashSet<String>> coveragePerLinePerTest = new HashMap<>();

	public void hit(int line, String test) {
		if (coveragePerLinePerTest.get(line) == null)
			coveragePerLinePerTest.put(line, new HashSet<String>());
		coveragePerLinePerTest.get(line).add(test);
	}
}
