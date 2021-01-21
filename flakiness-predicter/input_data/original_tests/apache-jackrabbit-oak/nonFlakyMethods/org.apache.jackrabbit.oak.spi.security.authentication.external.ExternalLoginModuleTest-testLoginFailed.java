@Test public void testLoginFailed() throws Exception {
  UserManager userManager=getUserManager(root);
  try {
    ContentSession cs=login(new SimpleCredentials("unknown",new char[0]));
    cs.close();
    fail("login failure expected");
  }
 catch (  LoginException e) {
  }
 finally {
    assertNull(userManager.getAuthorizable(userId));
  }
}
