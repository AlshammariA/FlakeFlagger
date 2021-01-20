package edu.gmu.swe.kp.report.jacoco;

import java.util.HashMap;
import java.util.HashSet;

public class JacocoRunInfo {
	public int linesCovered;
	public int totalLines;
	public int diffLinesCovered;
	public int totalDiffLines;
	public int totalClasses;
	public int classesCovered;
	public int totalMethods;
	public int methodsCovered;
	public int insnsCovered;
	public int totalInsns;
	public HashMap<String, JacocoRunInfo> runInfoPerTest;
	public HashSet<String> visitedClasses = new HashSet<String>();

	@Override
	public String toString() {
		return "Instructions: " + insnsCovered + "/" + totalInsns + ", Lines: " + linesCovered + "/" + totalLines + ", Classes: " + classesCovered + "/" + totalClasses + ", Methods: " + methodsCovered + "/" + totalMethods + ", DiffLines: " + diffLinesCovered + "/" + totalDiffLines;
	}
}
