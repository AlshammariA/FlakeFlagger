@Test public void testGetUserId(){
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  assertEquals(userId,info.getUserId());
  info=tokenProvider.getTokenInfo(info.getToken());
  assertEquals(userId,info.getUserId());
}
