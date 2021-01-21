@Test public void testConfigOptions2(){
  int exp=getConfig(TokenConfiguration.class).getParameters().getConfigValue(TokenProvider.PARAM_TOKEN_EXPIRATION,DEFAULT_EXPIRATION);
  assertEquals(60,exp);
}
