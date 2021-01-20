package edu.gmu.swe.kp.listener;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitResultFormatter;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitTest;
import edu.gmu.swe.kp.listener.MySQLLogger;
import edu.gmu.swe.kp.listener.MySQLLogger.TestResult;
import edu.gmu.swe.kp.listener.SharedHolder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.LinkedList;
//import org.junit.runner.Description;
//import org.junit.runner.notification.Failure;


public class AntTestExecutionListener implements JUnitResultFormatter {


	static MySQLLogger delegate;
	static FirebaseLogger firebase;
	static Field covFieldToReset;
	static FileWriter logger;

	static {
		if (System.getProperty("diffcov.mysql") != null && System.getProperty("diffcov.mysqllight") == null) {
			delegate = MySQLLogger.instance();
			delegate.testID = Integer.valueOf(System.getProperty("diffcov.studyid"));
			if (delegate.uuid == null)
				delegate.init("DummyProject", null, "" + delegate.testID);
		}
		if (System.getenv("TRAVIS") != null) {
			//set up firebase
			System.out.println("Connecting to firebase");
			if (SharedHolder.logger == null)
				SharedHolder.logger = new FirebaseLogger();
			firebase = (FirebaseLogger) SharedHolder.logger;
		}
	}

	static {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					logger.close();
					if (firebase != null)
						firebase.awaitExit();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}));
	}

	String lastTestClass = null;

//	@Override
//	public void testRunStarted(Description description) throws Exception {
//		if (!getClassName(description).equals(lastTestClass)) {
//			//we are doing another test class
//			if (res != null)
//				finishedClass();
//			methods.clear();
//			lastTestClass = getClassName(description);
//			if(lastTestClass == null || description == null || "null".equals(lastTestClass) || "classes".equals(lastTestClass))
//				return;
//			res = new TestResult(lastTestClass);
////			if (description != null && description.getChildren() != null && description.getChildren().size() == 1) {
////				Description child = description.getChildren().get(0);
////				long time = Long.valueOf(child.getDisplayName());
////				res.startTime = time;
////			}
//		}
//	}
	LinkedList<TestResult> methods = new LinkedList<TestResult>();
	TestResult thisMethod;
	boolean methodReported = false;
	int nErrors;

	String lastFinishedClass = null;

//	@Override
//	public void testRunFinished(Result result) throws Exception {
//		if(res == null)
//			return;
////		res.nFailures = result.getFailureCount();
////		if (!lastTestClass.equals(lastFinishedClass))
//			finishedClass();
////		lastFinishedClass = lastTestClass;
//			lastTestClass = null;
//			res = null;
//	}

	String className;
	String methodName;
	TestResult res;

//	/**
//	 * Called when an atomic test fails.
//	 * */
//	public void testFailure(Failure failure) throws java.lang.Exception {
//		if(failure.getDescription().getChildren() != null && !failure.getDescription().getChildren().isEmpty())
//		{
//			if (!getClassName(failure.getDescription()).equals(lastTestClass)) {
//				thisMethod = null;
//				if (res != null)
//					finishedClass();
//				res = new TestResult(getClassName(failure.getDescription()));
//				lastTestClass = getClassName(failure.getDescription());
//			}
//			//Make sure that the child method was created, it almost definitely wasn't
//			String methName = getMethodName(failure.getDescription().getChildren().get(0));
//			boolean found = false;
//			for(TestResult m : methods)
//				if(m.name.equals(methName))
//					found = true;
//			if(!found)
//			{
//				TestResult meth = new TestResult(methName);
//				meth.startTime = 0;
//				meth.endTime = 0;
//				meth.failed = true;
//				meth.exception = failure.getTrace();
//				methods.add(meth);
//				res.nMethods++;
//			}
//		}
//		if(res == null)
//			return;
//		res.nFailures++;
//		if (thisMethod != null) {
//			thisMethod.exception = failure.getTrace();
//			thisMethod.endTime = System.currentTimeMillis();
//			thisMethod.failed = true;
//		}
//		res.failed = true;
////		System.out.println(">>>"+failure.getDescription());
////		System.out.println("Failed on  " + failure.getTestHeader() + ": " + failure.getMessage() + Arrays.toString(failure.getException().getStackTrace()));
//	}

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

	private void finishedClass() {
		if (res.reported)
			return;

		res.reported = true;
		if (res.finished == 0)
			res.finished = System.currentTimeMillis();
		if (res.startTime == 0 && res.nMethods == 0)
			res.startTime = res.finished;

		if (firebase != null)
			firebase.log(res);

		res.methods = methods;
		methods = new LinkedList<TestResult>();
		if (delegate != null)
			synchronized (delegate.insertQueue) {
				// if (!delegate.inserter.isAlive() && delegate.senderDead) {
				// delegate.senderDead = false;
				// delegate.inserter.start();
				// }
				// System.out.println("Finished and sending" + res.name);
				if (res.name != null && !"null".equals(res.name)) {
					delegate.insertQueue.add(res);
					delegate.insertQueue.notifyAll();
				}
			}
	}

	@Override
	public void endTestSuite(JUnitTest test) throws BuildException {
		if (res != null)
			finishedClass();
		res = new TestResult(test.getName());
		lastTestClass = test.getName();
	}

	@Override
	public void setOutput(OutputStream arg0) {

	}

	@Override
	public void setSystemError(String arg0) {

	}

	@Override
	public void setSystemOutput(String arg0) {

	}

	@Override
	public void startTestSuite(JUnitTest arg0) throws BuildException {
	}

	@Override
	public void addError(Test arg0, Throwable arg1) {
		if (thisMethod != null)
			thisMethod.failed = true;
		if (res != null)
			res.nFailures++;
	}

	@Override
	public void addFailure(Test arg0, AssertionFailedError arg1) {
		if (thisMethod != null)
			thisMethod.failed = true;
		if (res != null)
			res.nFailures++;
	}

	@Override
	public void endTest(Test test) {
		if (thisMethod != null) {
			thisMethod.endTime = System.currentTimeMillis();
		}
		methodReported = true;
//		System.out.println(">>>"+description.getDisplayName() + "Finished\n");
//		if (description.getChildren() != null && description.getChildren().size() == 1) {
//			Description child = description.getChildren().get(0);
//			long time = Long.valueOf(child.getDisplayName());
//			res.finished = time;
//		}
	}

	@Override
	public void startTest(Test test) {
		if (test == null)
			return;
		if (lastTestClass == null || !getClassName(test).equals(lastTestClass)) {
			//we are doing another test class
//			System.out.println("Starting new test class");
			if (res != null)
				finishedClass();
			res = new TestResult(getClassName(test));
			lastTestClass = getClassName(test);
		}
		className = getClassName(test);
		methodName = getMethodName(test);
//		System.out.println(">>Start" + className+ "."+methodName + " ..." + test);
		TestResult m = new TestResult(getMethodName(test));
		m.startTime = System.currentTimeMillis();
		thisMethod = m;
		methods.add(m);
//		if (res.startTime == 0 && description.getChildren() != null && description.getChildren().size() == 1) {
//			Description child = description.getChildren().get(0);
//			long time = Long.valueOf(child.getDisplayName());
//			res.startTime = time;
//
//		}
		res.nMethods++;
	}
}
