@Test public void invalidBooleanFallbacksToFalse(){
  final Properties props=new Properties();
  props.setProperty(ConfigConstants.cacheGzippedContent.name(),"INVALID_BOOLEAN");
  factory=new PropertyWroConfigurationFactory(props);
  final WroConfiguration config=factory.create();
  Assert.assertEquals(false,config.isCacheGzippedContent());
}
