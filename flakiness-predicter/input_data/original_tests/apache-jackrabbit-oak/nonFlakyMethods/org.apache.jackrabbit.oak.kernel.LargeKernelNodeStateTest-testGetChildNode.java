@Test public void testGetChildNode(){
  assertTrue(state.getChildNode("x0").exists());
  assertTrue(state.getChildNode("x1").exists());
  assertTrue(state.getChildNode("x" + N).exists());
  assertFalse(state.getChildNode("x" + (N + 1)).exists());
}
