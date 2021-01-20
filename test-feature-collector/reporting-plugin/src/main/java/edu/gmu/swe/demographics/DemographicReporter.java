package edu.gmu.swe.demographics;

import edu.gmu.swe.smells.detector.internal.TestContext;
import org.apache.maven.project.MavenProject;
import org.eclipse.jgit.lib.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public abstract class DemographicReporter {
	protected PrintWriter output;
	public DemographicReporter(String outputFile)
	{
		try {
			output = new PrintWriter(new File(outputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected DemographicReporter(){

	}

	public final void close(){
		if(output != null) {
			output.close();
		}
	}
	/**
	 * Reports on some demographics about this project. Writes them out using the `output` printWriter
	 * @param tests
	 * @param project
	 * @param repo
	 */
	public abstract void getDemographicResults(Collection<TestContext> tests, MavenProject project, Repository repo, String projectSlug) throws IOException;
}
