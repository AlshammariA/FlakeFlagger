@Test public void testGetPrincipal() throws RepositoryException, NotExecutableException {
  assertNotNull(group.getPrincipal());
  assertNotNull(userMgr.getAuthorizable(group.getID()).getPrincipal());
}
