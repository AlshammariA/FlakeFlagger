@Test public void shouldUseConfiguredHashStrategy() throws Exception {
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableHashStrategy.KEY,MD5HashStrategy.ALIAS);
  victim.setConfigProperties(configProperties);
  final HashStrategy actual=((ConfigurableHashStrategy)victim.create().getHashStrategy()).getConfiguredStrategy();
  assertEquals(MD5HashStrategy.class,actual.getClass());
}
