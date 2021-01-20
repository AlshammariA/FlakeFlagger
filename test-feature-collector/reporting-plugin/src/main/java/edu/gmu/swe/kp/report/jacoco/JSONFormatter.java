package edu.gmu.swe.kp.report.jacoco;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class JSONFormatter {
	public HashMap<String, HashMap<String, LinkedList<Integer>>> cov = new HashMap<>();
	ObjectMapper mapper;
	ObjectWriter writer;
	OutputStream os;
	HashSet<String> allClasses;

	public JSONFormatter(OutputStream os, HashSet<String> allClasses) {
		mapper = new ObjectMapper();
		this.os = os;
		this.allClasses = allClasses;
		// writer = mapper.writer();
		writer = mapper.writer(new DefaultPrettyPrinter());
	}

	public void visitEnd() throws IOException {

		writer.writeValue(os, cov);
		os.close();
	}

	public void visitFile(String probeClass, HashMap<Integer, HashSet<String>> coveragePerLinePerTest) {
		//The map that we are passed goes from filename -> line number -> tests covering it

		//Easier to store as test -> files covered -> lines covered
		HashSet<LinkedList<Integer>> toSort = new HashSet<>();
		for (Integer line : coveragePerLinePerTest.keySet()) {
			for (String test : coveragePerLinePerTest.get(line)) {
				HashMap<String, LinkedList<Integer>> thisTestCov = cov.get(test);
				if (thisTestCov == null) {
					thisTestCov = new HashMap<>();
					cov.put(test, thisTestCov);
				}
				LinkedList<Integer> linesHitThisClassThistest = thisTestCov.get(probeClass);
				if (linesHitThisClassThistest == null) {
					linesHitThisClassThistest = new LinkedList<>();
					thisTestCov.put(probeClass, linesHitThisClassThistest);
				}
				linesHitThisClassThistest.add(line);
				toSort.add(linesHitThisClassThistest);
			}
		}
		for (LinkedList<Integer> t : toSort) {
			Collections.sort(t);
		}
	}

}
