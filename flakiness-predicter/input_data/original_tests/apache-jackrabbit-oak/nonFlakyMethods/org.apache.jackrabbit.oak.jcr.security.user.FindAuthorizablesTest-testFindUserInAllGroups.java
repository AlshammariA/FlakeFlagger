@Test public void testFindUserInAllGroups() throws RepositoryException, NotExecutableException {
  User u=null;
  try {
    Principal p=getTestPrincipal();
    String uid=createUserId();
    u=userMgr.createUser(uid,"pw",p,null);
    superuser.save();
    Iterator<Authorizable> it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,null,UserManager.SEARCH_TYPE_GROUP);
    while (it.hasNext()) {
      if (it.next().getPrincipal().getName().equals(p.getName())) {
        fail("Searching for Groups should never find a user");
      }
    }
  }
  finally {
    if (u != null) {
      u.remove();
      superuser.save();
    }
  }
}
