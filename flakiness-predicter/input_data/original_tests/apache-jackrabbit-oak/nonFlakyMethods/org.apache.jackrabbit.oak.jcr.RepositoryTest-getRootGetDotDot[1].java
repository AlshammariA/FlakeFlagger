@Test(expected=PathNotFoundException.class) public void getRootGetDotDot() throws RepositoryException {
  Node root=getNode("/");
  assertNotNull(root);
  root.getNode("..");
}
