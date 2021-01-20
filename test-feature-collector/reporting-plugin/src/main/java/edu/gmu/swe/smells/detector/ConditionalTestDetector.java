package edu.gmu.swe.smells.detector;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;

import java.util.Collection;

public class ConditionalTestDetector extends AbstractTestSmellDetector {
    public static final String KEY = "conditional-test-logic";
    boolean found = false;

    @Override
    public boolean checkForSmell(TestContext test, Collection<TestContext> otherContexts) {
        ASTNode body = test.getTestMethodBody();
        if(body == null){return false;}
        found = false;
        if(body==null) {
            return false;
        }
        body.accept(new ASTVisitor() {
            @Override
            public boolean visit(IfStatement node) {
                found = true;
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
