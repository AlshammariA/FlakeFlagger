@Test public void testEmpty(){
  List<TokenConfiguration> configs=getConfigurations();
  assertNotNull(configs);
  assertTrue(configs.isEmpty());
}
