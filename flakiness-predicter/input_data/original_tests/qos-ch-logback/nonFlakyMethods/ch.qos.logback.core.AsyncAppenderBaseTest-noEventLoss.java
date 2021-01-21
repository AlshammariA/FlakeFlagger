@Test(timeout=2000) public void noEventLoss(){
  int bufferSize=10;
  int loopLen=bufferSize * 2;
  asyncAppenderBase.addAppender(delayingListAppender);
  asyncAppenderBase.setQueueSize(bufferSize);
  asyncAppenderBase.start();
  for (int i=0; i < loopLen; i++) {
    asyncAppenderBase.doAppend(i);
  }
  asyncAppenderBase.stop();
  verify(delayingListAppender,loopLen);
}
