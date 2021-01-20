package edu.gmu.swe.smells.coverage;

import edu.gmu.swe.kp.report.jacoco.Analyzer;
import edu.gmu.swe.kp.report.jacoco.SessionCoverageVisitor;
import org.jacoco.core.data.*;
import org.jacoco.core.internal.analysis.StringPool;
import org.jacoco.core.tools.ExecFileLoader;
import org.jacoco.maven.FileFilter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class JacocoCoverageSource implements CoverageSource {
	final private String jacocoFile;
	final private String[] buildOutputDirs;
	private String curSession;

	public JacocoCoverageSource(String jacocoFile, String[] buildOutputDirs) {
		this.jacocoFile = jacocoFile;
		this.buildOutputDirs = buildOutputDirs;
	}

	@Override
	public void visitCoverage(SessionCoverageVisitor vis) {
		try {
			StringPool stringPool = new StringPool();
			ExecFileLoader loader = new ExecFileLoader();
			loader.load(new File(jacocoFile));
			final HashMap<String, HashMap<String, boolean[]>> dataPerSession = new HashMap<>();
			final ExecutionDataReader reader = new ExecutionDataReader(new BufferedInputStream(new FileInputStream(jacocoFile)));
			reader.setSessionInfoVisitor(new ISessionInfoVisitor() {

				@Override
				public void visitSessionInfo(SessionInfo info) {
					curSession = info.getId();
				}
			});
			reader.setExecutionDataVisitor(new IExecutionDataVisitor() {

				@Override
				public void visitClassExecution(ExecutionData data) {
					if (curSession != null) {
						HashMap<String, boolean[]> thisClass = dataPerSession.get(data.getName());
						if (thisClass == null) {
							thisClass = new HashMap<String, boolean[]>();
							dataPerSession.put(data.getName(), thisClass);
						}
						boolean[] thisSession = thisClass.get(curSession);
						if (thisSession == null)
							thisClass.put(curSession, data.getProbes());
						else {
							for (int i = 0; i < thisSession.length && i < data.getProbes().length; i++) {
								thisSession[i] |= data.getProbes()[i];
							}
						}
					}
				}
			});
			reader.read();
			final Analyzer analyzer = new Analyzer(dataPerSession, null, vis, stringPool);
			final org.jacoco.maven.FileFilter filter = new FileFilter(null, null);
			for (String dir : buildOutputDirs) {
				File f = new File(dir);
				if (f.isDirectory())
					for (final File file : filter.getFiles(f)) {
						analyzer.analyzeAll(file);
					}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
