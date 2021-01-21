@Test public void testGetPath() throws RepositoryException, NotExecutableException {
  assertNotNull(user.getPath());
  assertNotNull(userMgr.getAuthorizable(user.getID()).getPath());
  try {
    assertEquals(getNode(user,superuser).getPath(),user.getPath());
  }
 catch (  UnsupportedRepositoryOperationException e) {
  }
}
