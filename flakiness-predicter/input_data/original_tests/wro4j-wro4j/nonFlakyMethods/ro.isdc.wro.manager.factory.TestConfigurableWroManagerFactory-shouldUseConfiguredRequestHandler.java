@Test public void shouldUseConfiguredRequestHandler() throws Exception {
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableCacheStrategy.KEY,MemoryCacheStrategy.ALIAS);
  victim.setConfigProperties(configProperties);
  final CacheStrategy<?,?> actual=((ConfigurableCacheStrategy)AbstractDecorator.getOriginalDecoratedObject(victim.create().getCacheStrategy())).getConfiguredStrategy();
  assertEquals(MemoryCacheStrategy.class,actual.getClass());
}
