@Test public void testDetachAppenderByName() throws Exception {
  NOPAppender<TestEvent> ta=new NOPAppender<TestEvent>();
  ta.setName("test1");
  ta.start();
  aai.addAppender(ta);
  NOPAppender<TestEvent> tab=new NOPAppender<TestEvent>();
  tab.setName("test");
  tab.start();
  aai.addAppender(tab);
  assertTrue(aai.detachAppender("test"));
  assertTrue(aai.detachAppender("test1"));
  assertFalse(aai.detachAppender("test1"));
}
