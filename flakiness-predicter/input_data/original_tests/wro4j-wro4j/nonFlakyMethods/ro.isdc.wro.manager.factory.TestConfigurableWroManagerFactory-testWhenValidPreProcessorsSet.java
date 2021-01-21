@Test public void testWhenValidPreProcessorsSet(){
  createManager();
  configureValidUriLocators(mockFilterConfig);
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS)).thenReturn("cssUrlRewriting");
  assertEquals(1,processorsFactory.getPreProcessors().size());
}
