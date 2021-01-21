@Test public void hasPropertyDot() throws RepositoryException {
  Node root=getNode("/");
  assertFalse((root.hasProperty(".")));
  Node node=getNode("/foo");
  assertFalse((node.hasProperty(".")));
}
