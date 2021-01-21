@Test public void withoutRevisionId() throws Exception {
  SimpleNodeScenario scenario=new SimpleNodeScenario(mk);
  scenario.create();
  boolean exists=mk.nodeExists("/a",null);
  assertTrue(exists);
  scenario.deleteA();
  exists=mk.nodeExists("/a",null);
  assertFalse(exists);
}
