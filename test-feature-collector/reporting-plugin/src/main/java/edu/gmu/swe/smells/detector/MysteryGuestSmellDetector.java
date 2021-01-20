package edu.gmu.swe.smells.detector;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.eclipse.jdt.core.dom.*;

import java.util.Collection;

/**
 * A very simple Mystery Guest smell detector to demonstrate how the framework works
 *
 * @author jon
 */
public class MysteryGuestSmellDetector extends AbstractTestSmellDetector {
	public static final String KEY = "mystery-guest";
	boolean found;

	@Override
	public boolean checkForSmell(TestContext test, Collection<TestContext> others) {
		found = false;
		for (Statement s : test.getCoveredLines()) {
			s.accept(new ASTVisitor() {


				private void handle(Expression node, IMethodBinding iMethodBinding, String invokedName) {
					if (iMethodBinding == null || invokedName == null)
						return;
					ITypeBinding declaringClass = iMethodBinding.getDeclaringClass();
					if (declaringClass != null && declaringClass.getBinaryName() != null) {
						String invokedOwner = declaringClass.getBinaryName();

						if(invokedName == null || invokedOwner == null){
							return;
						}
						if (invokedName.equals("<init>") && invokedOwner.contains("java.io.File")) {
							// detecting file accessed ..
							found = true;
						} else if (invokedName.contains("getConnection") && invokedOwner.contains("java.sql")) {
							// detecting Database connection ..
							found = true;
						} else if (invokedName.contains("socket") && invokedOwner.contains("java.net")) {
							// detecting Network Socket ..
							found = true;
						}
						return;
					}
				}

				@Override
				public boolean visit(ClassInstanceCreation node) {
					if (node != null) {
						IMethodBinding iMethodBinding = node.resolveConstructorBinding();
						handle(node, iMethodBinding, "<init>");
					}
					return true;
				}

				@Override
				public boolean visit(MethodInvocation node) {
					if (node != null) {
						SimpleName name = node.getName();
						if (name != null) {
							String invokedName = name.getFullyQualifiedName();
							handle(node, node.resolveMethodBinding(), invokedName);
						}
					}
					return true;
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
