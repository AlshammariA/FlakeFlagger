@Test public void testResetTokenExpiration() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  assertFalse(info.resetExpiration(new Date().getTime()));
  long loginTime=new Date().getTime() + 3600000;
  assertFalse(info.isExpired(loginTime));
  assertTrue(info.resetExpiration(loginTime));
}
