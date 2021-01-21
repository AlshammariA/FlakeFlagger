@Test public void testConfigPropertiesWithValidPreProcessor(){
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS,"cssMin");
  victim.setConfigProperties(configProperties);
  createManager();
  final Collection<ResourcePreProcessor> list=processorsFactory.getPreProcessors();
  assertEquals(1,list.size());
  assertEquals(CssMinProcessor.class,list.iterator().next().getClass());
}
