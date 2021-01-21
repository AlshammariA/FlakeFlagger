@Test public void testResetTokenExpirationExpiredToken() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  long expiredTime=new Date().getTime() + 7200001;
  assertTrue(info.isExpired(expiredTime));
  assertFalse(info.resetExpiration(expiredTime));
}
