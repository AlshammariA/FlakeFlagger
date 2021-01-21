@Test public void testCreateUserPrincipalNameEqualsUserID() throws RepositoryException, NotExecutableException {
  User u=null;
  try {
    String uid=createUserId();
    u=userMgr.createUser(uid,"pw");
    superuser.save();
    String msg="User.getID() must return the userID pass to createUser.";
    assertEquals(msg,uid,u.getID());
    msg="Principal name must be the same as userID.";
    assertEquals(msg,uid,u.getPrincipal().getName());
  }
  finally {
    if (u != null) {
      u.remove();
      superuser.save();
    }
  }
}
