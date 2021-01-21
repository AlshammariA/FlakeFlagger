@Test(timeout=2000) public void workerShouldStopEvenIfInterruptExceptionConsumedWithinSubappender(){
  delayingListAppender.delay=100;
  asyncAppenderBase.addAppender(delayingListAppender);
  asyncAppenderBase.start();
  asyncAppenderBase.doAppend(0);
  asyncAppenderBase.stop();
  verify(delayingListAppender,1);
  assertTrue(delayingListAppender.interrupted);
}
