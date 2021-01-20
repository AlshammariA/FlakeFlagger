package edu.gmu.swe.smells.detector;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.eclipse.jdt.core.dom.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class RunWarDetector extends AbstractTestSmellDetector {
    public static final String KEY = "test-run-war";
    boolean found;

    @Override
    public boolean checkForSmell(TestContext test, Collection<TestContext> otherContexts) {
        found = false;
        checkForStaticNonFinalVariables(test);
        if(found)
            return true;
        checkForSameFile(test, otherContexts);
        return found;
    }

    private void checkForStaticNonFinalVariables(TestContext test) {
        ASTNode body = test.getTestMethodBody();
        if(body==null) {
            return;
        }
        // first create a list of disallowed variables
        ASTNode classNode = body.getParent();
        final List<String> staticNonFinalVariables = new ArrayList<>();
        classNode.accept(new ASTVisitor() {
            @Override
            public boolean visit(VariableDeclarationStatement node) {
                int m = node.getModifiers();
                if((m & Modifier.STATIC)==Modifier.STATIC && (m & Modifier.FINAL)!=Modifier.FINAL) {
                    staticNonFinalVariables.addAll(node.fragments());
                }
                return super.visit(node);
            }

            @Override
            public boolean visit(FieldDeclaration node) {
                int m = node.getModifiers();
                if((m & Modifier.STATIC)==Modifier.STATIC && (m & Modifier.FINAL)!=Modifier.FINAL) {
                    List<VariableDeclarationFragment> fragments = node.fragments();
                    for(VariableDeclarationFragment fragment : fragments) {
                        staticNonFinalVariables.add(fragment.getName().toString());
                    }
                }
                return super.visit(node);
            }
        });

        // then see if the method uses any of them
        body.accept(new ASTVisitor() {
            @Override
            public boolean visit(SimpleName node) {
                if(staticNonFinalVariables.contains(node.getIdentifier())) {
                    found = true;
                    return false;
                }
                return super.visit(node);
            }
        });
    }

    public void checkForSameFile(final TestContext test, Collection<TestContext> otherContexts) {
        ASTNode body = test.getTestMethodBody();
        if(body==null) {
            return;
        }

        // first, find all the files used for this method
        if(test.getNewFileLines() == null) {
            test.setNewFileLines(new HashSet<String>());
            body.accept(new ASTVisitor() {
                @Override
                public boolean visit(ClassInstanceCreation node) {
                    IMethodBinding binding = node.resolveConstructorBinding();
                    if (binding != null && binding.getDeclaringClass() != null) {
                        String fullName = binding.getDeclaringClass().getQualifiedName();
                        if (fullName != null && fullName.equals("java.io.File")) {
                            String arg = node.arguments().get(0).toString();
                            String fileName = arg.substring(1, arg.length() - 1);
                            test.getNewFileLines().add(fileName);
                        }
                    }
                    return super.visit(node);

                }
            });
        }

        // next, check whether any of those files are used by other methods

        for(final TestContext otherTest : otherContexts) {
            if(otherTest.toString().equals(test.toString()))
                continue;
            if(otherTest.getNewFileLines() == null) {
                otherTest.setNewFileLines(new HashSet<String>());
                ASTNode otherBody = otherTest.getTestMethodBody();
                if (otherBody == null)
                    continue;
                otherBody.accept(new ASTVisitor() {
                    @Override
                    public boolean visit(ClassInstanceCreation node) {
                        IMethodBinding binding = node.resolveConstructorBinding();
                        if(binding != null) {
                            String fullName = binding.getDeclaringClass().getQualifiedName();
                            if (fullName.equals("java.io.File")) {
                                String arg = node.arguments().get(0).toString();
                                if(arg.length() > 1) {
                                    String fileName = arg.substring(1, arg.length() - 1);
                                    otherTest.getNewFileLines().add(fileName);
                                }
                            }
                        }
                        return super.visit(node);
                    }
                });
            }
            for(String f : otherTest.getNewFileLines())
                if(test.getNewFileLines().contains(f))
                    found = true;
        }
    }

    @Override
    public String getName() {
        return KEY;
    }
}
