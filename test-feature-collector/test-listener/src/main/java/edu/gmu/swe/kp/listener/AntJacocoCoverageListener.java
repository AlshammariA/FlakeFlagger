package edu.gmu.swe.kp.listener;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitResultFormatter;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitTest;
import org.jacoco.agent.rt.IAgent;
import org.jacoco.agent.rt.RT;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

import java.io.IOException;
import java.io.OutputStream;

public class AntJacocoCoverageListener implements JUnitResultFormatter {
	public static boolean DUMP_PER_TEST_CLASS = true; //System.getenv("KP_JACOCO_PER_CLASS") != null;
	String lastTestClass = null;
	String lastMethodName = null;
	String className;
	String methodName;

	private String getMethodName(Test test) {
		String ret = null;

		if (test != null && test.toString().contains("(")) {
			ret = test.toString();
			if (ret != null) {
				ret = ret.substring(0, ret.indexOf('('));
			}
		} else if (test != null && test.toString().contains(":")) {
			ret = test.toString().split(":")[1];
		}
		return ret;
	}

	private String getClassName(Test test) {
		String ret = null;
//		System.out.println("Test is " + test + " " + test.getClass());

		if (test != null && test.toString().contains("(")) {
			ret = test.toString();
			if (ret != null) {
				ret = ret.substring(ret.indexOf('(') + 1, ret.length() - 1);
			}
			if (ret == null || ret.equals("null") || ret.equals("classes"))
				return ret;
		} else if (test != null && test.toString().contains(":")) {
			ret = test.toString().split(":")[0];
		} else {
			System.out.println("Test is " + test + " " + test.getClass());
		}
		return ret;
	}


	@Override
	public void startTestSuite(JUnitTest suite) throws BuildException {

	}

	@Override
	public void endTestSuite(JUnitTest suite) throws BuildException {

	}

	@Override
	public void setOutput(OutputStream out) {

	}

	@Override
	public void setSystemOutput(String out) {

	}

	@Override
	public void setSystemError(String err) {

	}

	@Override
	public void addError(Test test, Throwable t) {

	}

	@Override
	public void addFailure(Test test, AssertionFailedError t) {

	}

	@Override
	public void endTest(Test test) {

	}

	@Override
	public void startTest(Test test) {

		if (DUMP_PER_TEST_CLASS) {

			className = getClassName(test);
			methodName = getMethodName(test);
			if (!className.equals(lastTestClass) || !methodName.equals(lastMethodName)) {
				boolean isFirst = lastTestClass == null;
				lastTestClass = className;
				lastMethodName = methodName;
				if (lastTestClass == null || test == null || "null".equals(lastTestClass) || "classes".equals(lastTestClass))
					return;

				IAgent agent = RT.getAgent();
				agent.setSessionId(lastTestClass + "#"+lastMethodName);
				try {
					if (!isFirst)
						agent.dump(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				agent.setSessionId(className + "#"+methodName);
			}
		}
	}
}
