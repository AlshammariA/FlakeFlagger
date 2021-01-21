@Test public void testAuthenticate() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  assertTrue(authentication.authenticate(new TokenCredentials(info.getToken())));
}
