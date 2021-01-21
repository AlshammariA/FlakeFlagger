@Test public void testDetachAppender() throws Exception {
  NOPAppender<TestEvent> ta=new NOPAppender<TestEvent>();
  ta.start();
  aai.addAppender(ta);
  NOPAppender<TestEvent> tab=new NOPAppender<TestEvent>();
  tab.setName("test");
  tab.start();
  aai.addAppender(tab);
  assertTrue("Appender not detached",aai.detachAppender(tab));
  assertNull("Appender was not removed",aai.getAppender("test"));
  assertFalse("Appender detach error",aai.detachAppender(tab));
}
