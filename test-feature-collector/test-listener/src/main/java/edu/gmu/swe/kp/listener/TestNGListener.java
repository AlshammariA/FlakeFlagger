package edu.gmu.swe.kp.listener;

import edu.gmu.swe.kp.listener.MySQLLogger;
import edu.gmu.swe.kp.listener.MySQLLogger.TestResult;
import edu.gmu.swe.kp.listener.SharedHolder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class TestNGListener implements ITestListener {
	public final static boolean PRECISE = System.getProperty("diffcov.precise") != null;
	static FirebaseLogger firebase;
	static MySQLLogger delegate;

	static {
		if (System.getProperty("diffcov.mysql") != null && System.getProperty("diffcov.mysqllight") == null) {
			delegate = MySQLLogger.instance();
			delegate.testID = Integer.valueOf(System.getProperty("diffcov.studyid"));
			if (delegate.uuid == null)
				delegate.init("DummyProject", null, "" + delegate.testID);
		}
		if (System.getenv("TRAVIS") != null) {
			// set up firebase
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
				if (firebase != null)
					firebase.awaitExit();
			}
		}));
	}

	String lastTestClass = null;
	LinkedList<TestResult> methods = new LinkedList<TestResult>();
	TestResult thisMethod;
	String className;
	String methodName;
	TestResult res;
	boolean methodReported;

	private void finishedClass() {
		if (res == null)
			return;
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
	public void onTestStart(ITestResult description) {
		if (!getClassName(description).equals(lastTestClass)) {
			// we are doing another test class
			// System.out.println("Starting new test class");
			if (res != null)
				finishedClass();
			res = new TestResult(getClassName(description));
			lastTestClass = getClassName(description);
		}
		className = getClassName(description);
		methodName = getMethodName(description);

		// System.out.println(">>Start" + className+ "."+methodName);
		TestResult m = new TestResult(getMethodName(description));
		m.startTime = System.currentTimeMillis();
		thisMethod = m;
		methods.add(m);

		res.nMethods++;
	}

	private String getMethodName(ITestResult description) {
		return description.getMethod().getMethodName();
	}

	private String getClassName(ITestResult description) {
		String ret = description.getTestClass().getName();
		if (System.getProperty("deflaker.inProcessRerun") != null)
			return "deflaker.inProcessRerun$" + ret;
		else if (System.getProperty("deflaker.isInRerunFork") != null)
			return "deflaker.inForkRerun$" + ret;
		return ret;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		onFinish(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		res.nFailures++;
		res.failed = true;
		if (thisMethod != null) {
			thisMethod.failed = true;
			if (result.getThrowable() != null)
				thisMethod.exception = result.getThrowable().toString();
		}
		onFinish(result);
	}

	void onFinish(ITestResult description) {
		if (thisMethod != null)
			thisMethod.endTime = System.currentTimeMillis();
		// thisMethod.failed = false;
		methodReported = true;
		// System.out.println(">>>"+description.getDisplayName() +
		// "Finished\n");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (res != null) {
			res.nSkips++;
			if (thisMethod != null) {
				thisMethod.endTime = System.currentTimeMillis();
				thisMethod.skipped = true;
				if (result.getThrowable() != null)
					thisMethod.exception = result.getThrowable().toString();
			}
			onFinish(result);
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		onFinish(result);
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		finishedClass();

	}

}
