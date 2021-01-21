@Test public void getPropertyWithRelativePath() throws RepositoryException {
  Session s=getAdminSession();
  try {
    s.getProperty("some-relative-path");
    fail("Session.getProperty() with relative path must throw a RepositoryException");
  }
 catch (  RepositoryException e) {
  }
}
