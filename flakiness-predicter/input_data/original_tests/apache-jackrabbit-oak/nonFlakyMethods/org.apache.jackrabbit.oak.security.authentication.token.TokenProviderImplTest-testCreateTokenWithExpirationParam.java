@Test public void testCreateTokenWithExpirationParam() throws Exception {
  SimpleCredentials sc=new SimpleCredentials(userId,new char[0]);
  sc.setAttribute(TokenProvider.PARAM_TOKEN_EXPIRATION,100000);
  TokenInfo info=tokenProvider.createToken(sc);
  assertTokenInfo(info,userId);
  Tree tokenTree=getTokenTree(info);
  assertNotNull(tokenTree);
  assertTrue(tokenTree.exists());
  assertTrue(tokenTree.hasProperty(TokenProvider.PARAM_TOKEN_EXPIRATION));
  assertEquals(100000,tokenTree.getProperty(TokenProvider.PARAM_TOKEN_EXPIRATION).getValue(Type.LONG).longValue());
}
