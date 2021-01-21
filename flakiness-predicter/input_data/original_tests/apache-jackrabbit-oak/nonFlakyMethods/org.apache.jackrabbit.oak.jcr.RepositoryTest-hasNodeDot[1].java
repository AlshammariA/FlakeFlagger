@Test public void hasNodeDot() throws RepositoryException {
  Node root=getNode("/");
  assertTrue(root.hasNode("."));
  Node node=getNode("/foo");
  assertTrue(node.hasNode("."));
}
