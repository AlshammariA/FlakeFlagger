package edu.gmu.swe.smells.detector;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.eclipse.jdt.core.dom.*;

import java.util.Collection;

public class EagerDetector extends AbstractTestSmellDetector {
    public static final String KEY = "eager-test";
    boolean found = false;

    @Override
    public boolean checkForSmell(TestContext test, Collection<TestContext> otherContexts) {
        found = false;
        String fullTestClassName = test.getTestClassName();
        final String testClassName = fullTestClassName.substring(fullTestClassName.lastIndexOf("/") + 1);
        String productionClassName_tmp = testClassName.replace("Test", "");
        final String productionClassNameSplit[] = productionClassName_tmp.split("[.]");
        final String productionClassName = productionClassNameSplit[productionClassNameSplit.length - 1];

        ASTNode body = test.getTestMethodBody();
        if(body == null){return false;}
        body.accept(new ASTVisitor() {
            String invokedMethod = null;
            @Override
            public boolean visit(MethodInvocation node) {

//                String invokedOwner = node.resolveMethodBinding().getDeclaringClass().getBinaryName();
                if(node!= null){
                    IMethodBinding iMethodBinding = node.resolveMethodBinding();
                    if(iMethodBinding!=null){
                        ITypeBinding declaringClass = iMethodBinding.getDeclaringClass();
                        if(declaringClass!= null){
                            String invokedOwner = declaringClass.getBinaryName();
                            String[] invokedOwnerSplit = invokedOwner.split("[.]");
                            if(invokedOwnerSplit[invokedOwnerSplit.length - 1].equals(productionClassName)) {
                                String methodName = node.getName().toString();
                                if(invokedMethod==null) {
                                    invokedMethod = methodName;
                                }
                                else if(!invokedMethod.equals(methodName)) {
                                    found = true;
                                    return false;
                                }
                            }
                        }
                    }
                }

                return super.visit(node);
            }
        });
        return found;
    }

    @Override
    public String getName() {
        return KEY;
    }
}
