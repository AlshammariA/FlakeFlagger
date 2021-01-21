@Test public void siblingDelete() throws Exception {
  SimpleNodeScenario scenario=new SimpleNodeScenario(mk);
  scenario.create();
  scenario.deleteB();
  boolean exists=mk.nodeExists("/a/b",null);
  assertFalse(exists);
  exists=mk.nodeExists("/a/c",null);
  assertTrue(exists);
}
