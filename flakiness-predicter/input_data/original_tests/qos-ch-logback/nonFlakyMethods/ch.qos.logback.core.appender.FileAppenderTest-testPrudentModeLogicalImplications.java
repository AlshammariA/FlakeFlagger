@Test public void testPrudentModeLogicalImplications(){
  String filename=CoreTestConstants.OUTPUT_DIR_PREFIX + diff + "fat-testPrudentModeLogicalImplications.txt";
  File file=new File(filename);
  FileAppender<Object> appender=new FileAppender<Object>();
  appender.setEncoder(new DummyEncoder<Object>());
  appender.setFile(filename);
  appender.setName("testPrudentModeLogicalImplications");
  appender.setContext(context);
  appender.setAppend(false);
  appender.setPrudent(true);
  appender.start();
  assertTrue(appender.isAppend());
  StatusManager sm=context.getStatusManager();
  StatusChecker statusChecker=new StatusChecker(context);
  assertEquals(Status.WARN,statusChecker.getHighestLevel(0));
  List<Status> statusList=sm.getCopyOfStatusList();
  assertTrue("Expecting status list size to be 2 or larger, but was " + statusList.size(),statusList.size() >= 2);
  String msg1=statusList.get(1).getMessage();
  assertTrue("Got message [" + msg1 + "]",msg1.startsWith("Setting \"Append\" property"));
  appender.doAppend(new Object());
  appender.stop();
  assertTrue(file.exists());
  assertTrue("failed to delete " + file.getAbsolutePath(),file.delete());
}
