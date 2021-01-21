@Test public void testUnknownUserLogin() throws RepositoryException {
  String uid=createUserId();
  assertNull(userMgr.getAuthorizable(uid));
  try {
    Session s=superuser.getRepository().login(new SimpleCredentials(uid,uid.toCharArray()));
    s.logout();
    fail("An unknown user should not be allowed to execute the login.");
  }
 catch (  Exception e) {
  }
}
