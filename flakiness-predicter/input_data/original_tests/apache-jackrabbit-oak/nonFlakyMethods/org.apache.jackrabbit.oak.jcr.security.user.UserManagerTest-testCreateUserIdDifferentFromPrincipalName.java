@Test public void testCreateUserIdDifferentFromPrincipalName() throws RepositoryException, NotExecutableException {
  User u=null;
  Session uSession=null;
  try {
    Principal p=getTestPrincipal();
    String uid=createUserId();
    u=userMgr.createUser(uid,"pw",p,null);
    superuser.save();
    String msg="Creating a User with principal-name distinct from Principal-name must succeed as long as both are unique.";
    assertEquals(msg,u.getID(),uid);
    assertEquals(msg,p.getName(),u.getPrincipal().getName());
    assertFalse(msg,u.getID().equals(u.getPrincipal().getName()));
    uSession=superuser.getRepository().login(new SimpleCredentials(uid,"pw".toCharArray()));
    assertEquals(uid,uSession.getUserID());
  }
  finally {
    if (uSession != null) {
      uSession.logout();
    }
    if (u != null) {
      u.remove();
      superuser.save();
    }
  }
}
