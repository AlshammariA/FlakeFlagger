@Test public void hasPropertyDotDot() throws RepositoryException {
  Node root=getNode("/");
  assertFalse((root.hasProperty("..")));
  Node node=getNode("/foo");
  assertFalse((node.hasProperty("..")));
}
