@Test public void testGetAuthorizable() throws RepositoryException {
  Authorizable a=mgr.getAuthorizable(UserConstants.DEFAULT_ANONYMOUS_ID);
  assertNotNull(a);
  assertTrue(a instanceof AuthorizableImpl);
  assertTrue(a instanceof UserImpl);
  a=mgr.getAuthorizableByPath(a.getPath());
  assertNotNull(a);
  assertTrue(a instanceof AuthorizableImpl);
  assertTrue(a instanceof UserImpl);
  a=mgr.getAuthorizable(a.getPrincipal());
  assertNotNull(a);
  assertTrue(a instanceof AuthorizableImpl);
  assertTrue(a instanceof UserImpl);
  assertNull(mgr.getAuthorizable("unknown"));
}
