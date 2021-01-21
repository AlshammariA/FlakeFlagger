@Test public void testLoginFailed() throws Exception {
  try {
    ContentSession cs=login(new SimpleCredentials(USER_ID,new char[0]));
    cs.close();
    fail("login failure expected");
  }
 catch (  LoginException e) {
  }
 finally {
    assertNull(userManager.getAuthorizable(USER_ID));
  }
}
