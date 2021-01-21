@Test public void parentDelete() throws Exception {
  SimpleNodeScenario scenario=new SimpleNodeScenario(mk);
  scenario.create();
  boolean exists=mk.nodeExists("/a/b",null);
  assertTrue(exists);
  scenario.deleteA();
  exists=mk.nodeExists("/a/b",null);
  assertFalse(exists);
}
