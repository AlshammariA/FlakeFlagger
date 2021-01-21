@Test public void testFindUserInAllUsers() throws RepositoryException, NotExecutableException {
  User u=null;
  try {
    Principal p=getTestPrincipal();
    String uid=createUserId();
    u=userMgr.createUser(uid,"pw",p,null);
    superuser.save();
    boolean found=false;
    Iterator<Authorizable> it=userMgr.findAuthorizables("./" + UserConstants.REP_PRINCIPAL_NAME,null,UserManager.SEARCH_TYPE_USER);
    while (it.hasNext() && !found) {
      User nu=(User)it.next();
      found=nu.getID().equals(uid);
    }
    assertTrue("Searching for 'null' must find the created user.",found);
  }
  finally {
    if (u != null) {
      u.remove();
      superuser.save();
    }
  }
}
