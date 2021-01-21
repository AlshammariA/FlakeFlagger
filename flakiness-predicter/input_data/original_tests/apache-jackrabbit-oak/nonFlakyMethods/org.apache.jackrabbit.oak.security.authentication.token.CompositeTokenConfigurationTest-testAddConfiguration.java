@Test public void testAddConfiguration(){
  TokenConfigurationImpl tc=new TokenConfigurationImpl(getSecurityProvider());
  addConfiguration(tc);
  List<TokenConfiguration> configs=getConfigurations();
  assertNotNull(configs);
  assertEquals(1,configs.size());
  addConfiguration(tc);
  configs=getConfigurations();
  assertNotNull(configs);
  assertEquals(2,configs.size());
  addConfiguration(new TokenConfigurationImpl(getSecurityProvider()));
  configs=getConfigurations();
  assertNotNull(configs);
  assertEquals(3,configs.size());
}
