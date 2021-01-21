@Test public void withInvalidRevisionId() throws Exception {
  SimpleNodeScenario scenario=new SimpleNodeScenario(mk);
  scenario.create();
  try {
    mk.nodeExists("/a","123456789");
    fail("Expected: Invalid revision id exception");
  }
 catch (  Exception expected) {
  }
}
