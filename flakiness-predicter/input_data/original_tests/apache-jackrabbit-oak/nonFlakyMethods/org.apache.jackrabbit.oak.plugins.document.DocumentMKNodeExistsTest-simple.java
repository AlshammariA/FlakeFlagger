@Test public void simple() throws Exception {
  SimpleNodeScenario scenario=new SimpleNodeScenario(mk);
  String revisionId=scenario.create();
  boolean exists=mk.nodeExists("/a",revisionId);
  assertTrue(exists);
  exists=mk.nodeExists("/a/b",revisionId);
  assertTrue(exists);
  revisionId=scenario.deleteA();
  exists=mk.nodeExists("/a",revisionId);
  assertFalse(exists);
  exists=mk.nodeExists("/a/b",revisionId);
  assertFalse(exists);
}
