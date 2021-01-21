@Test(timeout=2000) public void emptyQueueShouldBeStoppable(){
  asyncAppenderBase.addAppender(listAppender);
  asyncAppenderBase.start();
  asyncAppenderBase.stop();
  verify(listAppender,0);
}
