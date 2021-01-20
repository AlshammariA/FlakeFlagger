package edu.gmu.swe.smells.detector;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.eclipse.jdt.core.dom.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A very simple Resources Optimism smell detector to demonstrate how the framework works
 *
 * @author jon
 */
public class ResourceOptimismSmellDetector extends AbstractTestSmellDetector {
	public static final String KEY = "resource-optimism";
	boolean found;
	boolean flag;
	final ArrayList<String> setUpFilesAndPaths = new ArrayList<String>();

	@Override
	public boolean checkForSmell(TestContext test, Collection<TestContext> others) {
		found = false;
		flag = false;
		MethodDeclaration setupMethod = test.getJdtContext().getMethod(test.getTestClassName(),"setUp","()V");

		if(setupMethod != null) {
			setupMethod.getBody().accept(new ASTVisitor() {
				@Override
				public boolean visit(ClassInstanceCreation node) {
					IMethodBinding owner = node.resolveConstructorBinding();
					if (owner != null && owner.getDeclaringClass() != null && owner.getDeclaringClass().getQualifiedName().equals("java.io.File")) {
						if (node.arguments().size() == 1 && node.arguments().get(0) != null)
							setUpFilesAndPaths.add(node.arguments().get(0).toString());

					}
					return super.visit(node);
				}
			});
		}
		for (Statement s : test.getCoveredLines()) {
			s.accept(new ASTVisitor() {
				@Override
				public boolean visit(ClassInstanceCreation node) {
					//String invokedOwner = node.resolveMethodBinding().getDeclaringClass().getBinaryName();
					if(node != null){
						IMethodBinding iMethodBinding = node.resolveConstructorBinding();
						if (iMethodBinding != null){
							ITypeBinding declaringClass = iMethodBinding.getDeclaringClass();
							if(declaringClass!= null){
								String invokedOwner = declaringClass.getBinaryName();
								if (invokedOwner != null && invokedOwner.equals("java.io.File") && node.arguments().size() == 1) {
									Object arg = node.arguments().get(0);
									if(arg != null) {
										if (setUpFilesAndPaths.isEmpty()) {
											flag = true;
										} else {
											for (String x : setUpFilesAndPaths) {
												if (!arg.toString().contains(x)
														|| !arg.toString().contains(x + ".getPath();")
														|| !arg.toString().contains(x + ".getAbsolutePath();")
														|| !arg.toString().contains(x + ".getCanonicalPath();")) {
													flag = true;
												}
											}
										}
									}
									if(flag){
										found = true;
									}
								}
							}
						}
					}

					return super.visit(node);
				}
			});}
		setUpFilesAndPaths.clear();
		return found;
	}

	@Override
	public String getName() {
		return KEY;
	}
}
