@Test public void testIteratorForAppenders() throws Exception {
  NOPAppender<TestEvent> ta=new NOPAppender<TestEvent>();
  ta.start();
  aai.addAppender(ta);
  NOPAppender<TestEvent> tab=new NOPAppender<TestEvent>();
  tab.setName("test");
  tab.start();
  aai.addAppender(tab);
  Iterator<Appender<TestEvent>> iter=aai.iteratorForAppenders();
  int size=0;
  while (iter.hasNext()) {
    ++size;
    Appender<TestEvent> app=iter.next();
    assertTrue("Bad Appender",app == ta || app == tab);
  }
  assertTrue("Incorrect number of appenders",size == 2);
}
