@Test public void testGetToken(){
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  assertNotNull(info.getToken());
  info=tokenProvider.getTokenInfo(info.getToken());
  assertNotNull(info.getToken());
}
