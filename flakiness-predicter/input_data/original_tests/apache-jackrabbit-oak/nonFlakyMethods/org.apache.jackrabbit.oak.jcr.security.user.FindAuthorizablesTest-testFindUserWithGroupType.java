@Test public void testFindUserWithGroupType() throws RepositoryException, NotExecutableException {
  User u=null;
  try {
    Principal p=getTestPrincipal();
    String uid=createUserId();
    u=userMgr.createUser(uid,"pw",p,null);
    superuser.save();
    Iterator<Authorizable> it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,p.getName(),UserManager.SEARCH_TYPE_GROUP);
    assertFalse("Searching for Groups should not find the user",it.hasNext());
  }
  finally {
    if (u != null) {
      u.remove();
      superuser.save();
    }
  }
}
