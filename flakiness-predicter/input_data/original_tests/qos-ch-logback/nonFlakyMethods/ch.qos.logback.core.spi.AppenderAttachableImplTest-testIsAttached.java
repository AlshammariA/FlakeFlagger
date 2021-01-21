@Test public void testIsAttached() throws Exception {
  NOPAppender<TestEvent> ta=new NOPAppender<TestEvent>();
  ta.start();
  aai.addAppender(ta);
  NOPAppender<TestEvent> tab=new NOPAppender<TestEvent>();
  tab.setName("test");
  tab.start();
  aai.addAppender(tab);
  assertTrue("Appender is not attached",aai.isAttached(ta));
  assertTrue("Appender is not attached",aai.isAttached(tab));
}
