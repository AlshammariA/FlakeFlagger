@Test public void testGetPath() throws RepositoryException, NotExecutableException {
  assertNotNull(group.getPath());
  assertNotNull(userMgr.getAuthorizable(group.getID()).getPath());
  try {
    assertEquals(getNode(group,superuser).getPath(),group.getPath());
  }
 catch (  UnsupportedRepositoryOperationException e) {
  }
}
