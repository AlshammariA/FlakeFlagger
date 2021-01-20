package edu.gmu.swe.smells.detector;

import edu.gmu.swe.smells.detector.internal.AbstractTestSmellDetector;
import edu.gmu.swe.smells.detector.internal.TestContext;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AssertionRouletteDetector extends AbstractTestSmellDetector {
    public static final String KEY = "assertion-roulette";
    private static final List<String> assertMethods = Arrays.asList("assertArrayEquals", "assertEquals", "assertFalse", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertThat", "assertTrue", "fail");
    int numAsserts = 0;
    @Override
    public boolean checkForSmell(TestContext test, Collection<TestContext> otherContexts) {
    	numAsserts = 0; // :)
        ASTNode body = test.getTestMethodBody();
        if(body==null) {return false;}
        body.accept(new ASTVisitor() {
            @Override
            public boolean visit(MethodInvocation node) {
                if (assertMethods.contains(node.getName().toString())) {
                    numAsserts++;
                }
                return super.visit(node);
            }
        });

        return numAsserts > 1;
    }
    @Override
    public String getName() {
        return KEY;
    }
}
