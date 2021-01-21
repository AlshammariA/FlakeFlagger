@Test public void testFindAuthorizable() throws RepositoryException {
  Iterator<Authorizable> res=mgr.findAuthorizables(UserConstants.REP_AUTHORIZABLE_ID,UserConstants.DEFAULT_ANONYMOUS_ID);
  assertTrue(res.hasNext());
  Authorizable a=res.next();
  assertNotNull(a);
  assertTrue(a instanceof AuthorizableImpl);
}
