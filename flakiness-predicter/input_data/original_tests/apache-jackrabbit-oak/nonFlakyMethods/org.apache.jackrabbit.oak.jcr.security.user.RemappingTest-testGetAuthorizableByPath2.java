@Test public void testGetAuthorizableByPath2() throws Exception {
  try {
    getUserManager(session).getAuthorizableByPath(user.getPath());
    fail("invalid path must be detected");
  }
 catch (  RepositoryException e) {
  }
}
