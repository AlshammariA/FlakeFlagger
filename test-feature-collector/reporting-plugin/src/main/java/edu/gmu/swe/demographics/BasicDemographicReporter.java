package edu.gmu.swe.demographics;

import edu.gmu.swe.smells.Utils;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.apache.maven.project.MavenProject;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jgit.lib.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BasicDemographicReporter extends DemographicReporter {
    int numAsserts = 0;
    private static final List<String> assertMethods = Arrays.asList("assertArrayEquals", "assertEquals", "assertFalse", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertThat", "assertTrue", "fail");

    public BasicDemographicReporter(String outputFile) {
        super(outputFile);
    }

    @Override
    public void getDemographicResults(Collection<TestContext> tests, MavenProject project, Repository repo, String repoName) throws IOException {
        output.println("project,testClassName,testMethodName,testLength,numAsserts,numCoveredLines");
        for(TestContext test : tests) {
            // test length
            ASTNode body = test.getTestMethodBody();
            if(body == null) continue;
            CompilationUnit compilationUnit = test.getCompilationUnit();
            int len = compilationUnit.getLineNumber(body.getLength() + body.getStartPosition()) -
                    compilationUnit.getLineNumber(body.getStartPosition());

            // number of asserts
            numAsserts = 0;
            body.accept(new ASTVisitor() {
                @Override
                public boolean visit(MethodInvocation node) {
                    if (assertMethods.contains(node.getName().toString())) {
                        numAsserts++;
                    }
                    return super.visit(node);
                }
            });

            // number of covered lines
            int numLines = test.getCoveredLines().size();

            output.println(Utils.escapeStrForOutput(repoName) + "," + Utils.escapeStrForOutput(
                    test.getTestClassName()) + "," + Utils.escapeStrForOutput(test.getTestMethodName()) +
                    "," + len + "," + numAsserts + "," + numLines);
        }
    }
}
