@Test public void testGetID() throws NotExecutableException, RepositoryException {
  assertNotNull(group.getID());
  assertNotNull(userMgr.getAuthorizable(group.getID()).getID());
}
