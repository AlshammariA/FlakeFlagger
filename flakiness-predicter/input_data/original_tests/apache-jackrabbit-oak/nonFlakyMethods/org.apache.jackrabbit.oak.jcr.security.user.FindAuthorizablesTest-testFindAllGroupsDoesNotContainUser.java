@Test public void testFindAllGroupsDoesNotContainUser() throws RepositoryException {
  Iterator<Authorizable> it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,null,UserManager.SEARCH_TYPE_GROUP);
  while (it.hasNext()) {
    assertTrue(it.next().isGroup());
  }
}
