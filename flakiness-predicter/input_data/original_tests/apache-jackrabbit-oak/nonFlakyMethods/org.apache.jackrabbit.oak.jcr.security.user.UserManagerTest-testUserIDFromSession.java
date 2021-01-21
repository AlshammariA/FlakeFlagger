@Test public void testUserIDFromSession() throws RepositoryException, NotExecutableException {
  User u=null;
  Session uSession=null;
  try {
    String uid=createUserId();
    u=userMgr.createUser(uid,"pw");
    superuser.save();
    uSession=superuser.getRepository().login(new SimpleCredentials(uid,"pw".toCharArray()));
    assertEquals(u.getID(),uSession.getUserID());
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
