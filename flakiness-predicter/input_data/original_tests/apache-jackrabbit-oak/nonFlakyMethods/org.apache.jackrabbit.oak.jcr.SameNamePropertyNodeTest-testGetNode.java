@Test public void testGetNode() throws Exception {
  assertTrue(n.isSame(testRootNode.getNode(sameName)));
  assertFalse(n.isSame(p));
}
