@Test(timeout=2000) public void smoke(){
  asyncAppenderBase.addAppender(listAppender);
  asyncAppenderBase.start();
  asyncAppenderBase.doAppend(0);
  asyncAppenderBase.stop();
  verify(listAppender,1);
}
