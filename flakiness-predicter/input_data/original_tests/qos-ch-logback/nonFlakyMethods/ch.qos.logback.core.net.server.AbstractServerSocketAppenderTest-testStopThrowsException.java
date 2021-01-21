@Test public void testStopThrowsException() throws Exception {
  appender.start();
  assertTrue(appender.isStarted());
  IOException ex=new IOException("test exception");
  runner.setStopException(ex);
  appender.stop();
  Status status=context.getLastStatus();
  assertNotNull(status);
  assertTrue(status instanceof ErrorStatus);
  assertTrue(status.getMessage().contains(ex.getMessage()));
  assertSame(ex,status.getThrowable());
}
