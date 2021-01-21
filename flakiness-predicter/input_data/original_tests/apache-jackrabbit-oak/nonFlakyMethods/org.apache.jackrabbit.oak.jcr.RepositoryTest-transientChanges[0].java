@Test public void transientChanges() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  Node node=parentNode.addNode("test");
  assertFalse(node.hasProperty("p"));
  node.setProperty("p","pv");
  assertTrue(node.hasProperty("p"));
  assertFalse(node.hasNode("n"));
  node.addNode("n");
  assertTrue(node.hasNode("n"));
  assertTrue(node.hasProperties());
  assertTrue(node.hasNodes());
}
