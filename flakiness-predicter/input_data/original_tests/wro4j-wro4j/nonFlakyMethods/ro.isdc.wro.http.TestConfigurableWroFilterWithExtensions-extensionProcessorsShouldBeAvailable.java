@Test public void extensionProcessorsShouldBeAvailable() throws Exception {
  final ConfigurableWroFilter filter=new ConfigurableWroFilter();
  final Properties properties=new Properties();
  properties.setProperty(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS,RhinoCoffeeScriptProcessor.ALIAS);
  filter.setProperties(properties);
  filter.init(mockFilterConfig);
  final WroManagerFactory factory=filter.newWroManagerFactory();
  final WroManager wroManager=factory.create();
  final ProcessorsFactory processorsFactory=wroManager.getProcessorsFactory();
  final Collection<ResourcePostProcessor> postProcessors=processorsFactory.getPostProcessors();
  assertEquals(1,postProcessors.size());
}
