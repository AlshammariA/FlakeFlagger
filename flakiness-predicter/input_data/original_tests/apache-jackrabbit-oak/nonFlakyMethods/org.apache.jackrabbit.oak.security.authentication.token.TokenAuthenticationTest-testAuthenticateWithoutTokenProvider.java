@Test public void testAuthenticateWithoutTokenProvider() throws Exception {
  Authentication authentication=new TokenAuthentication(null);
  assertFalse(authentication.authenticate(new TokenCredentials("token")));
}
