@Test public void testGetTokenInfoAfterAuthenticate() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  authentication.authenticate(new TokenCredentials(info.getToken()));
  TokenInfo info2=authentication.getTokenInfo();
  assertNotNull(info2);
  assertEquals(info.getUserId(),info2.getUserId());
}
