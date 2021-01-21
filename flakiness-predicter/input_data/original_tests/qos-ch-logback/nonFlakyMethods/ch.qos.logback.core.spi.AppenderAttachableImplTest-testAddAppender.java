@Test public void testAddAppender() throws Exception {
  TestEvent event=new TestEvent();
  NOPAppender<TestEvent> ta=new NOPAppender<TestEvent>();
  ta.start();
  aai.addAppender(ta);
  ta=new NOPAppender<TestEvent>();
  ta.setName("test");
  ta.start();
  aai.addAppender(ta);
  int size=aai.appendLoopOnAppenders(event);
  assertTrue("Incorrect number of appenders",size == 2);
}
