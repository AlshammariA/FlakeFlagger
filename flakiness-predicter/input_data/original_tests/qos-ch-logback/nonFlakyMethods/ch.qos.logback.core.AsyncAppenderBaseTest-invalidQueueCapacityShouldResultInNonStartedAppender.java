@Test public void invalidQueueCapacityShouldResultInNonStartedAppender(){
  asyncAppenderBase.addAppender(new NOPAppender<Integer>());
  asyncAppenderBase.setQueueSize(0);
  assertEquals(0,asyncAppenderBase.getQueueSize());
  asyncAppenderBase.start();
  assertFalse(asyncAppenderBase.isStarted());
  statusChecker.assertContainsMatch("Invalid queue size");
}
