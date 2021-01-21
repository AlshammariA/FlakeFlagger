@Test public void exceptionsShouldNotCauseHalting() throws InterruptedException {
  NPEAppender npeAppender=new NPEAppender<Integer>();
  npeAppender.setName("bad");
  npeAppender.setContext(context);
  npeAppender.start();
  asyncAppenderBase.addAppender(npeAppender);
  asyncAppenderBase.start();
  assertTrue(asyncAppenderBase.isStarted());
  for (int i=0; i < 10; i++)   asyncAppenderBase.append(i);
  asyncAppenderBase.stop();
  assertFalse(asyncAppenderBase.isStarted());
  assertEquals(AppenderBase.ALLOWED_REPEATS,statusChecker.matchCount("Appender \\[bad\\] failed to append."));
}
