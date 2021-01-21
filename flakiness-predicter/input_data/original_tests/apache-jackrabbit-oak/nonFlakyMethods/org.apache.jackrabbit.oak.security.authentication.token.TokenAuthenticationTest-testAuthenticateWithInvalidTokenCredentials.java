@Test public void testAuthenticateWithInvalidTokenCredentials() throws Exception {
  try {
    authentication.authenticate(new TokenCredentials(UUID.randomUUID().toString()));
    fail("LoginException expected");
  }
 catch (  LoginException e) {
  }
}
