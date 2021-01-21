@Test public void getNodeFromNode() throws RepositoryException {
  Node root=getNode("/");
  Node node=root.getNode("foo");
  assertNotNull(node);
  assertEquals("foo",node.getName());
  assertEquals("/foo",node.getPath());
  Node nodeAgain=getNode("/foo");
  assertTrue(node.isSame(nodeAgain));
}
