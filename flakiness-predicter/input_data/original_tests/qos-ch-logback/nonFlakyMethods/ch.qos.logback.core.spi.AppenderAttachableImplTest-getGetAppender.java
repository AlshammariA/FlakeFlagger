@Test public void getGetAppender() throws Exception {
  NOPAppender<TestEvent> test=new NOPAppender<TestEvent>();
  test.setName("test");
  test.start();
  aai.addAppender(test);
  NOPAppender<TestEvent> testOther=new NOPAppender<TestEvent>();
  testOther.setName("testOther");
  testOther.start();
  aai.addAppender(testOther);
  Appender<TestEvent> a=aai.getAppender("testOther");
  assertNotNull("Could not find appender",a);
  assertTrue("Wrong appender",a == testOther);
  a=aai.getAppender("test");
  assertNotNull("Could not find appender",a);
  assertTrue("Wrong appender",a == test);
  a=aai.getAppender("NotThere");
  assertNull("Appender was returned",a);
}
