package edu.gmu.swe.demographics;

import edu.gmu.swe.smells.detector.internal.TestContext;
import org.apache.maven.project.MavenProject;
import org.eclipse.jgit.lib.Repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class TestMethodExporterReporter extends DemographicReporter {

    private File outputDir;
    public TestMethodExporterReporter(String outputFile) {
        this.outputDir = new File(outputFile);
        this.outputDir.mkdir();
    }

    @Override
    public void getDemographicResults(Collection<TestContext> tests, MavenProject project, Repository repo, String projectSlug) throws IOException {
        for(TestContext test : tests){
            if(test.getTestMethodBody() != null) {
                String fileName = test.getTestClassName() + "#" + test.getTestMethodName() + ".testMethod";
                File output = new File(outputDir, fileName);
                FileOutputStream fos = new FileOutputStream(output);
                PrintWriter pw = new PrintWriter(fos);
                pw.write(test.getTestMethodBody().toString());
                pw.close();
            }
        }
    }
}
