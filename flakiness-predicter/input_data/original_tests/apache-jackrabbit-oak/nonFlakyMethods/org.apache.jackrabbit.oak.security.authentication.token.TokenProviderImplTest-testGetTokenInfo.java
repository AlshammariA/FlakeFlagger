@Test public void testGetTokenInfo() throws Exception {
  String token=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap()).getToken();
  TokenInfo info=tokenProvider.getTokenInfo(token);
  assertTokenInfo(info,userId);
}
