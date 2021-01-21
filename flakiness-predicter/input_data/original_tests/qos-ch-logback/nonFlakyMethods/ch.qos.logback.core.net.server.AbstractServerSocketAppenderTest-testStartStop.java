@Test public void testStartStop() throws Exception {
  appender.start();
  assertTrue(runner.isContextInjected());
  assertTrue(runner.isRunning());
  assertSame(listener,appender.getLastListener());
  appender.stop();
  assertFalse(runner.isRunning());
}
