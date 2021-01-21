@Test public void getNodeDotDot() throws RepositoryException {
  Node node=getNode("/foo");
  Node root=node.getNode("..");
  assertNotNull(root);
  assertEquals("",root.getName());
  assertTrue(root.isSame(node.getParent()));
}
