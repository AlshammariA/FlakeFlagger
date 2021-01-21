@Test public void testIsExpired(){
  long loginTime=new Date().getTime();
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  assertFalse(info.isExpired(loginTime));
  loginTime=new Date().getTime() + 3600000;
  assertFalse(info.isExpired(loginTime));
  long expiredTime=new Date().getTime() + 7200001;
  assertTrue(info.isExpired(expiredTime));
}
