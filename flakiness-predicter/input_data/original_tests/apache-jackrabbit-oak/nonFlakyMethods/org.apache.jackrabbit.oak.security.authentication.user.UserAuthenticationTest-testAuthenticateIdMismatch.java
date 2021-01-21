@Test public void testAuthenticateIdMismatch() throws Exception {
  try {
    authentication.authenticate(new SimpleCredentials("unknownUser","pw".toCharArray()));
    fail("LoginException expected");
  }
 catch (  LoginException e) {
  }
}
