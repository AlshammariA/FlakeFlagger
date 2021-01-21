@Test public void smoke(){
  String filename=CoreTestConstants.OUTPUT_DIR_PREFIX + "/fat-smoke.log";
  FileAppender<Object> appender=new FileAppender<Object>();
  appender.setEncoder(new DummyEncoder<Object>());
  appender.setAppend(false);
  appender.setFile(filename);
  appender.setName("smoke");
  appender.setContext(context);
  appender.start();
  appender.doAppend(new Object());
  appender.stop();
  File file=new File(filename);
  assertTrue(file.exists());
  assertTrue("failed to delete " + file.getAbsolutePath(),file.delete());
}
