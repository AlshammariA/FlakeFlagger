@Test public void testCreateTokenFromUserId() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  assertTokenInfo(info,userId);
}
