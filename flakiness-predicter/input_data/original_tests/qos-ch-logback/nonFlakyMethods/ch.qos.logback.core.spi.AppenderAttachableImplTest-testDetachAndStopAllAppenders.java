@Test public void testDetachAndStopAllAppenders() throws Exception {
  NOPAppender<TestEvent> ta=new NOPAppender<TestEvent>();
  ta.start();
  aai.addAppender(ta);
  NOPAppender<TestEvent> tab=new NOPAppender<TestEvent>();
  tab.setName("test");
  tab.start();
  aai.addAppender(tab);
  assertTrue("Appender was not started",tab.isStarted());
  aai.detachAndStopAllAppenders();
  assertNull("Appender was not removed",aai.getAppender("test"));
  assertFalse("Appender was not stopped",tab.isStarted());
}
