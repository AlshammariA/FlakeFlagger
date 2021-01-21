@Test public void getItemWithRelativePath() throws RepositoryException {
  Session s=getAdminSession();
  try {
    s.getItem("some-relative-path");
    fail("Session.getItem() with relative path must throw a RepositoryException");
  }
 catch (  RepositoryException e) {
  }
}
