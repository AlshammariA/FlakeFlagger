@Test public void testConfigureCacheUpdatePeriod(){
  Mockito.when(filterConfig.getInitParameter(ConfigConstants.cacheUpdatePeriod.name())).thenReturn("10");
  final WroConfiguration config=factory.create();
  Assert.assertEquals(10,config.getCacheUpdatePeriod());
  Assert.assertEquals(true,config.isDebug());
}
