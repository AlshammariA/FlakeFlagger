@Test public void existsInOldRevNotInNewRev() throws Exception {
  SimpleNodeScenario scenario=new SimpleNodeScenario(mk);
  String rev1=scenario.create();
  String rev2=scenario.deleteA();
  boolean exists=mk.nodeExists("/a",rev1);
  assertTrue(exists);
  exists=mk.nodeExists("/a",rev2);
  assertFalse(exists);
}
