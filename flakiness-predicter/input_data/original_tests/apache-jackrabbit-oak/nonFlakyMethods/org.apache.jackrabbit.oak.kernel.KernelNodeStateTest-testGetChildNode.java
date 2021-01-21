@Test public void testGetChildNode(){
  assertTrue(state.getChildNode("x").exists());
  assertTrue(state.getChildNode("y").exists());
  assertTrue(state.getChildNode("z").exists());
  assertFalse(state.getChildNode("a").exists());
}
