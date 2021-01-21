@Test(expected=RepositoryException.class) public void getNodeAbsolutePath() throws RepositoryException {
  Node root=getNode("/");
  root.getNode("/foo");
}
