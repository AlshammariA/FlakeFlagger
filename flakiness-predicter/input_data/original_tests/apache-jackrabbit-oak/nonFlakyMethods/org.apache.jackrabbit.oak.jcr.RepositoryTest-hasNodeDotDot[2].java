@Test public void hasNodeDotDot() throws RepositoryException {
  Node root=getNode("/");
  assertFalse(root.hasNode(".."));
  Node node=getNode("/foo");
  assertTrue(node.hasNode(".."));
}
