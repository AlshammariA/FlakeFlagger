@Test public void testProcessorsExecutionOrder(){
  createManager();
  configureValidUriLocators(mockFilterConfig);
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS)).thenReturn(AbstractConfigurableMultipleStrategy.createItemsAsString(JSMinProcessor.ALIAS,CssImportPreProcessor.ALIAS,CssVariablesProcessor.ALIAS));
  final List<ResourcePreProcessor> list=(List<ResourcePreProcessor>)processorsFactory.getPreProcessors();
  assertEquals(JSMinProcessor.class,list.get(0).getClass());
  assertEquals(CssImportPreProcessor.class,list.get(1).getClass());
  assertEquals(CssVariablesProcessor.class,list.get(2).getClass());
}
