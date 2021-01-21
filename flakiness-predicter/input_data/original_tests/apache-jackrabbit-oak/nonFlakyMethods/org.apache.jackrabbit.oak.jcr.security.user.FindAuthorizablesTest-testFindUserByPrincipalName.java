@Test public void testFindUserByPrincipalName() throws RepositoryException, NotExecutableException {
  User u=null;
  try {
    Principal p=getTestPrincipal();
    String uid=createUserId();
    u=userMgr.createUser(uid,"pw",p,null);
    superuser.save();
    boolean found=false;
    Iterator<Authorizable> it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,p.getName(),UserManager.SEARCH_TYPE_USER);
    while (it.hasNext() && !found) {
      User nu=(User)it.next();
      found=nu.getPrincipal().getName().equals(p.getName());
    }
    assertTrue("Searching for principal-name must find the created user.",found);
    it=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,p.getName(),UserManager.SEARCH_TYPE_GROUP);
    assertFalse(it.hasNext());
  }
  finally {
    if (u != null) {
      u.remove();
      superuser.save();
    }
  }
}
