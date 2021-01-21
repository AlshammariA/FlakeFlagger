@Test public void testStartStop() throws Exception {
  assertFalse(runner.isRunning());
  executor.execute(runner);
  assertTrue(runner.awaitRunState(true,DELAY));
  int retries=DELAY / SHORT_DELAY;
synchronized (listener) {
    while (retries-- > 0 && listener.getWaiter() == null) {
      listener.wait(SHORT_DELAY);
    }
  }
  assertNotNull(listener.getWaiter());
  runner.stop();
  assertTrue(listener.isClosed());
  assertFalse(runner.awaitRunState(false,DELAY));
}
