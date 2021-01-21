@Test public void testConfigPropertiesWithMultipleValidPostProcessor(){
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS,"jsMin, cssMin");
  victim.setConfigProperties(configProperties);
  createManager();
  assertEquals(2,processorsFactory.getPostProcessors().size());
  assertEquals(JSMinProcessor.class,((ProcessorDecorator)processorsFactory.getPostProcessors().iterator().next()).getDecoratedObject().getClass());
}
