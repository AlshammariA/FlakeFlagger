package edu.gmu.swe.demographics;

import edu.gmu.swe.smells.Utils;
import edu.gmu.swe.smells.coverage.JacocoCoverageSource;
import edu.gmu.swe.smells.detector.internal.DetectorEntryPoint;
import edu.gmu.swe.smells.detector.internal.JDTContext;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.apache.maven.project.MavenProject;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class LibrariesUsageReporter extends DemographicReporter{
    public LibrariesUsageReporter(String outputFile) {
        super(outputFile);
    }


    @Override
    public void getDemographicResults(Collection<TestContext> tests, MavenProject project, Repository repo, String rootProjectName) throws IOException {
        output.println("project,testClassName,testMethodName,libraryName");
        for(TestContext test : tests) {
        	for( Statement s : test.getCoveredLines()){
        		s.accept(new ASTVisitor() {
    				@Override
    				public boolean visit(MethodInvocation node) {
    					if(node.resolveMethodBinding() == null)
    						return false;
    					String invokedOwner = node.resolveMethodBinding().getDeclaringClass().getBinaryName();
    					output.println(Utils.escapeStrForOutput(rootProjectName) + "," + Utils.escapeStrForOutput(
    							test.getTestClassName()) + "," + Utils.escapeStrForOutput(test.getTestMethodName()) +
								"," + invokedOwner);
    					return super.visit(node);
    					//return true;
    				}});
        	}
         }
    }
}
