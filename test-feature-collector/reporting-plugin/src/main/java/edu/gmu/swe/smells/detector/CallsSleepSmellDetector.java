package edu.gmu.swe.smells.detector;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.JDTContext;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Statement;

import java.util.Collection;

/**
 * A very simple smell detector to demonstrate how the framework works
 *
 * Skims for any call to java.lang.Thread.sleep. Notice how it uses JDT to resolve the binding of
 * the method call (node.resolveMethodBinding().getDeclaringClass()) - this is the magic that gets
 * us the fully qualified name (java.lang.Thread), which JDT infers from analyzing all of the source files.
 *
 * @author jon
 */
public class CallsSleepSmellDetector extends AbstractTestSmellDetector {
	public static final String KEY = "calls-sleep";
	boolean found;

	@Override
	public boolean checkForSmell(TestContext test, Collection<TestContext> others) {
		found = false;
		for (Statement s : test.getCoveredLines()) {
			s.accept(new ASTVisitor() {
				@Override
				public boolean visit(MethodInvocation node) {
					if(node.resolveMethodBinding() != null && node.resolveMethodBinding().getDeclaringClass() != null) {
						String invokedName = node.getName().getFullyQualifiedName();
						String invokedOwner = node.resolveMethodBinding().getDeclaringClass().getBinaryName();
						if (invokedName.equals("sleep") && invokedOwner.equals("java.lang.Thread"))
							found = true;
						if (found)
							return false;
					}
					return super.visit(node);
				}
			});
		}
		return found;
	}

	@Override
	public String getName() {
		return KEY;
	}

}
