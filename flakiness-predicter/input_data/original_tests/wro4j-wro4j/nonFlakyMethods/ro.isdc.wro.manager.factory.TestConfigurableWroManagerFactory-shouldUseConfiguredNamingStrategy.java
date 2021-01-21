@Test public void shouldUseConfiguredNamingStrategy() throws Exception {
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableNamingStrategy.KEY,TimestampNamingStrategy.ALIAS);
  victim.setConfigProperties(configProperties);
  final NamingStrategy actual=((ConfigurableNamingStrategy)victim.create().getNamingStrategy()).getConfiguredStrategy();
  assertEquals(TimestampNamingStrategy.class,actual.getClass());
}
