@Test public void testFindAllUsersDoesNotContainGroup() throws RepositoryException {
  Iterator<Authorizable> it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,null,UserManager.SEARCH_TYPE_USER);
  while (it.hasNext()) {
    assertFalse(it.next().isGroup());
  }
}
