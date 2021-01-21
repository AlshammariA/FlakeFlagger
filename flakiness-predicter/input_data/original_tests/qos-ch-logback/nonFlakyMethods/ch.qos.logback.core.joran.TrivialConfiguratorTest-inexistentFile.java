@Test public void inexistentFile(){
  TrivialStatusListener tsl=new TrivialStatusListener();
  tsl.start();
  String filename=CoreTestConstants.TEST_SRC_PREFIX + "input/joran/" + "nothereBLAH.xml";
  context.getStatusManager().add(tsl);
  try {
    doTest(filename);
  }
 catch (  Exception e) {
    assertTrue(e.getMessage().startsWith("Could not open ["));
  }
  assertTrue(tsl.list.size() + " should be greater than or equal to 1",tsl.list.size() >= 1);
  Status s0=tsl.list.get(0);
  assertTrue(s0.getMessage().startsWith("Could not open ["));
}
