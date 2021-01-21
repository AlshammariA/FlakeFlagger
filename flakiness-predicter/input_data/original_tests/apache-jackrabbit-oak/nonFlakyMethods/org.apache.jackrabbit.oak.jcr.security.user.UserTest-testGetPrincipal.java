@Test public void testGetPrincipal() throws RepositoryException, NotExecutableException {
  assertNotNull(user.getPrincipal());
  assertNotNull(userMgr.getAuthorizable(user.getID()).getPrincipal());
}
