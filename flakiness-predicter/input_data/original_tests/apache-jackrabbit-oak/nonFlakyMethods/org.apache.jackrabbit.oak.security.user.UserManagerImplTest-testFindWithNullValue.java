@Test public void testFindWithNullValue() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,null);
  assertTrue(result.hasNext());
  result=userMgr.findAuthorizables("./" + UserConstants.REP_PRINCIPAL_NAME,null);
  assertTrue(result.hasNext());
}
