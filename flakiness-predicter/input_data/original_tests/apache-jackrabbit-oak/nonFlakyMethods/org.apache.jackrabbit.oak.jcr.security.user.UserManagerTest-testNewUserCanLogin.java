@Test public void testNewUserCanLogin() throws RepositoryException, NotExecutableException {
  String uid=createUserId();
  User u=null;
  Session s=null;
  try {
    u=userMgr.createUser(uid,"pw");
    superuser.save();
    Credentials creds=new SimpleCredentials(uid,"pw".toCharArray());
    s=superuser.getRepository().login(creds);
  }
  finally {
    if (u != null) {
      u.remove();
      superuser.save();
    }
    if (s != null) {
      s.logout();
    }
  }
}
