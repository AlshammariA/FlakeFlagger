@Test public void testAnonymousLogin() throws Exception {
  String anonymousID=UserUtil.getAnonymousId(getUserConfiguration().getParameters());
  UserManager userMgr=getUserManager(root);
  Authorizable anonymous=userMgr.getAuthorizable(anonymousID);
  assertNotNull(anonymous);
  assertFalse(root.getTree(anonymous.getPath()).hasProperty(UserConstants.REP_PASSWORD));
  ContentSession cs=null;
  try {
    cs=login(new SimpleCredentials(anonymousID,new char[0]));
    fail("Login with anonymousID should fail since the initial setup doesn't provide a password.");
  }
 catch (  LoginException e) {
  }
 finally {
    if (cs != null) {
      cs.close();
    }
  }
}
