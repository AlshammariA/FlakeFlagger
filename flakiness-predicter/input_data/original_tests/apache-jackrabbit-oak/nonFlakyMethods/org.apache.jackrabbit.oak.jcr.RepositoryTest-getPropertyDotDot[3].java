@Test(expected=PathNotFoundException.class) public void getPropertyDotDot() throws RepositoryException {
  Node node=getNode("/foo");
  node.getProperty("..");
}
