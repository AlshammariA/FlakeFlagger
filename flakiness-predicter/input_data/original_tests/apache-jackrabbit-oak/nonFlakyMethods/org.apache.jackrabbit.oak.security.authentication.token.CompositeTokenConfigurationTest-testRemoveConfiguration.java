@Test public void testRemoveConfiguration(){
  TokenConfiguration tc=new TokenConfigurationImpl(getSecurityProvider());
  addConfiguration(tc);
  List<TokenConfiguration> configs=getConfigurations();
  assertNotNull(configs);
  assertEquals(1,configs.size());
  removeConfiguration(tc);
  configs=getConfigurations();
  assertNotNull(configs);
  assertEquals(0,configs.size());
}
