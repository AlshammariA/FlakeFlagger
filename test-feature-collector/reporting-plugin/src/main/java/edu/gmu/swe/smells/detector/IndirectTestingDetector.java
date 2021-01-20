package edu.gmu.swe.smells.detector;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.eclipse.jdt.core.dom.*;

import java.util.Collection;

public class IndirectTestingDetector extends AbstractTestSmellDetector {
    public static final String KEY = "indirect-testing";
    boolean found;

    private static TypeDeclaration getDeclaringType(ASTNode s)
    {
        if(s instanceof TypeDeclaration || s == null)
            return (TypeDeclaration) s;
        return getDeclaringType(s.getParent());
    }
    @Override
    public boolean checkForSmell(TestContext test, Collection<TestContext> otherContexts) {
        found =false;
        String fullTestClassName = test.getTestClassName();
        final String testClassNameWithoutPackage = fullTestClassName.substring(fullTestClassName.lastIndexOf(".") + 1).split("[.]")[0];


        String productionClassName_tmp = testClassNameWithoutPackage.replace("TestCase","").replace("Test", "");
        final String productionClassNameSplit[] = productionClassName_tmp.split("[.]");
        final String productionClassNameWithoutPackage = productionClassNameSplit[productionClassNameSplit.length - 1];

        if(test.getCompilationUnit() != null && test.getCompilationUnit().getPackage() != null) {
            String packageName = test.getCompilationUnit().getPackage().getName().getFullyQualifiedName();
            final String firstPackageQualifier = packageName.split("[.]")[0];

            for (Statement s : test.getCoveredLines()) {
            	TypeDeclaration declaringType = getDeclaringType(s);
            	if(declaringType == null || declaringType.resolveBinding() == null || declaringType.resolveBinding().getQualifiedName() == null)
            	    continue;
            	String name = declaringType.resolveBinding().getQualifiedName();

                if (name.equals(fullTestClassName))
                    s.accept(new ASTVisitor() {
                        @Override
                        public boolean visit(MethodInvocation node) {
                        	if(node.resolveMethodBinding() == null)
                        	    return super.visit(node);
                            String invokedOwner = node.resolveMethodBinding().getDeclaringClass().getBinaryName();
                            String[] invokedOwnerSplit = invokedOwner.split("[.]");
                            if (invokedOwnerSplit[0].equals(firstPackageQualifier) //If top level package meets, e.g. edu.gmu.swe -> edu
                                    && !invokedOwnerSplit[invokedOwnerSplit.length - 1].equals(productionClassNameWithoutPackage) //And it's not the production class
                                    && !invokedOwnerSplit[invokedOwnerSplit.length - 1].equals(testClassNameWithoutPackage) //and it's not the test class
                            ) {
                                found = true;
                                return false;
                            }
                            return super.visit(node);
                        }
                    });
            }
        }
        return found;
    }

    @Override
    public String getName() {
        return KEY;
    }
}
