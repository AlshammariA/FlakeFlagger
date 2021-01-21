@Test public void illFormedXML(){
  TrivialStatusListener tsl=new TrivialStatusListener();
  tsl.start();
  String filename=CoreTestConstants.TEST_SRC_PREFIX + "input/joran/" + "illformed.xml";
  context.getStatusManager().add(tsl);
  try {
    doTest(filename);
  }
 catch (  Exception e) {
  }
  assertEquals(1,tsl.list.size());
  Status s0=tsl.list.get(0);
  assertTrue(s0.getMessage().startsWith(CoreConstants.XML_PARSING));
}
