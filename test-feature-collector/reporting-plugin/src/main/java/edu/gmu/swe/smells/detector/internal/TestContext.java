package edu.gmu.swe.smells.detector.internal;

import org.eclipse.jdt.core.dom.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * Basic representation of the context of a test's execution
 * Passed to smell detectors for evaluation
 *
 * getCoveredLines() is likely the most important method for smell detectors to use of this class
 *
 * @author jon
 */
public class TestContext {
	private final String testClassName;
	private final String testMethodName;
	private final ASTNode testMethodBody;
	private final CompilationUnit compilationUnit;
	private final JDTContext jdtContext;
	private final HashMap<String, HashSet<Integer>> coveredClassesAndTheirLines = new HashMap<>();
	private HashSet<String> newFileLines;


	TestContext(String testClassName, String testMethodName, ASTNode testMethodBody, JDTContext jdtContext) {
		this.testClassName = testClassName;
		this.testMethodName = testMethodName;
		this.testMethodBody = testMethodBody;
		this.jdtContext = jdtContext;
		if (testMethodBody != null)
			this.compilationUnit = (CompilationUnit) testMethodBody.getRoot();
		else
			this.compilationUnit = null;
	}

	public void setNewFileLines(HashSet<String> newFileLines) {
		this.newFileLines = newFileLines;
	}

	public HashSet<String> getNewFileLines() {
		return newFileLines;
	}

	/**
	 * Use the JDTContext (sparingly) to investigate specific AST elements.
	 *
	 * It is preferred that instead your smell detector just uses getCoveredLines() to inspect
	 * each line that is covered by this test
	 *
	 * @return
	 */
	public JDTContext getJdtContext() {
		return jdtContext;
	}

	public String getTestClassName() {
		return testClassName;
	}

	public String getTestMethodName() {
		return testMethodName;
	}

	public ASTNode getTestMethodBody() {
		return testMethodBody;
	}

	public CompilationUnit getCompilationUnit() { return compilationUnit;}

	public void addHitLines(String probeClass, HashSet<Integer> coveredLines) {
		coveredClassesAndTheirLines.put(probeClass, coveredLines);
	}

	public HashMap<String, HashSet<Integer>> getCoveredClassesAndTheirLines() {
		return coveredClassesAndTheirLines;
	}

	public LinkedList<Statement> getCoveredLines() {
		final LinkedList<Statement> ret = new LinkedList<>();
		if (compilationUnit == null)
			return ret;

		for (final Map.Entry<String, HashSet<Integer>> each : coveredClassesAndTheirLines.entrySet()) {
			final BodyDeclaration bodyDeclaration = jdtContext.getAST(each.getKey());
			if (bodyDeclaration != null)//right now we aren't going to be able to get anonymous inner classes
				bodyDeclaration.accept(new ASTVisitor() {
					@Override
					public boolean visit(MethodDeclaration node) {
						if (node.getBody() != null && node.getBody().statements() != null)
							for (Object o : node.getBody().statements()) {
								Statement s = (Statement) o;
								int line = compilationUnit.getLineNumber(s.getStartPosition());
								if (each.getValue().contains(line))
									ret.add(s);
							}
						return true;
					}
				});
		}
		return ret;
	}

	@Override
	public String toString() {
		return "TestContext{" +
				"testClassName='" + testClassName + '\'' +
				", testMethodName='" + testMethodName + '\'' +
				'}';
	}
}
