package edu.gmu.swe.demographics;

import edu.gmu.swe.smells.Utils;
import edu.gmu.swe.smells.coverage.JacocoCoverageSource;
import edu.gmu.swe.smells.detector.internal.DetectorEntryPoint;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.apache.maven.plugins.surefire.report.ReportTestCase;
import org.apache.maven.plugins.surefire.report.ReportTestSuite;
import org.apache.maven.plugins.surefire.report.SurefireReportParser;
import org.apache.maven.project.MavenProject;
import org.apache.maven.reporting.MavenReportException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class ExecutionTimeReporter extends DemographicReporter{
	HashSet<File> surefireReportDirs = new HashSet<>();
    public ExecutionTimeReporter(String outputFile, String[] buildOutputDirs) {
        super(outputFile);
        for(String dir : buildOutputDirs)
        {
        	File f = new File(dir);
        	File reportDir = new File(f.getParentFile(),"surefire-reports");
        	if(reportDir.exists())
        	    surefireReportDirs.add(reportDir);
	        reportDir = new File(f.getParentFile(),"failsafe-reports");
	        if(reportDir.exists())
		        surefireReportDirs.add(reportDir);
        }
    }


    @Override
    public void getDemographicResults(Collection<TestContext> tests, MavenProject project, Repository repo, String rootProjectName) throws IOException {
        output.println("project,testClassName,testMethodName,ExecutionTime");
        List<File> reportDirs = new ArrayList<>();
        reportDirs.addAll(surefireReportDirs);

	    SurefireReportParser parser = new SurefireReportParser(reportDirs,Locale.US);

	    try {
		    for(ReportTestSuite suite : parser.parseXMLReportFiles()){
		    	for(ReportTestCase c : suite.getTestCases()){
				    output.println(rootProjectName+","+c.getFullClassName()+","+ Utils.escapeStrForOutput(c.getName())+","+c.getTime());
			    }
		    }
	    } catch (MavenReportException e) {
		    e.printStackTrace();
	    }
    }
}
