@Test(timeout=2000) public void lossyAppenderShouldBeNonLossyIfDiscardingThresholdIsZero(){
  int bufferSize=5;
  int loopLen=bufferSize * 2;
  lossyAsyncAppender.addAppender(delayingListAppender);
  lossyAsyncAppender.setQueueSize(bufferSize);
  lossyAsyncAppender.setDiscardingThreshold(0);
  lossyAsyncAppender.start();
  for (int i=0; i < loopLen; i++) {
    lossyAsyncAppender.doAppend(i);
  }
  lossyAsyncAppender.stop();
  verify(delayingListAppender,loopLen);
}
