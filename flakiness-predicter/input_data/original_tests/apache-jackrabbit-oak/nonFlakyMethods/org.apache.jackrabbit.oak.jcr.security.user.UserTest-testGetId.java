@Test public void testGetId() throws NotExecutableException, RepositoryException {
  assertNotNull(user.getID());
  assertNotNull(userMgr.getAuthorizable(user.getID()).getID());
}
