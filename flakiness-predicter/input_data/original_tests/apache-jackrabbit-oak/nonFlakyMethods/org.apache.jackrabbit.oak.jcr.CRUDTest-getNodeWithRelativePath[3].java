@Test public void getNodeWithRelativePath() throws RepositoryException {
  Session s=getAdminSession();
  try {
    s.getNode("some-relative-path");
    fail("Session.getNode() with relative path must throw a RepositoryException");
  }
 catch (  RepositoryException e) {
  }
}
