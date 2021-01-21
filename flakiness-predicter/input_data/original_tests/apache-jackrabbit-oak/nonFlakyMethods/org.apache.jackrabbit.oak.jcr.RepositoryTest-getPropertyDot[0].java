@Test(expected=PathNotFoundException.class) public void getPropertyDot() throws RepositoryException {
  Node node=getNode("/foo");
  node.getProperty(".");
}
