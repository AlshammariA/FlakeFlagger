package edu.gmu.swe.smells.detector;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.JDTContext;
import edu.gmu.swe.smells.detector.internal.TestContext;

import org.apache.xml.serialize.Method;
import org.eclipse.jdt.core.dom.*;

import java.util.Collection;

/**
 * A very simple FIRE smell detector to demonstrate how the framework works
 *
 * @author jon
 */
public class FireAndForgetSmellDetector extends AbstractTestSmellDetector {
	public static final String KEY = "fire-and-forget";
	boolean found;

	@Override
	public boolean checkForSmell(TestContext test, Collection<TestContext> others) {
		found = false;
		for (Statement s : test.getCoveredLines()) {
			s.accept(new ASTVisitor() {
				@Override
				public boolean visit(MethodInvocation node) {
					if(node != null){
						IMethodBinding iMethodBinding = node.resolveMethodBinding();
						if(iMethodBinding != null){
							ITypeBinding declaringClass = iMethodBinding.getDeclaringClass();
							if(declaringClass != null && declaringClass.getBinaryName() != null){
								String invokedOwner = declaringClass.getBinaryName();
								if (invokedOwner.contains("java.lang.Thread") || invokedOwner.contains("java.util.concurrent") || invokedOwner.contains("java.lang.Runnable"))
									found = true;
							}
						}

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
