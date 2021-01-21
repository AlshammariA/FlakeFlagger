@Test public void testConfigOptions(){
  int exp=tc.getParameters().getConfigValue(TokenProvider.PARAM_TOKEN_EXPIRATION,DEFAULT_EXPIRATION);
  assertEquals(60,exp);
}
