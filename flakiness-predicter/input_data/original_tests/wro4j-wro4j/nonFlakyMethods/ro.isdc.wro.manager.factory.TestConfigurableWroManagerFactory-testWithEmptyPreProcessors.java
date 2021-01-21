@Test public void testWithEmptyPreProcessors(){
  createManager();
  configureValidUriLocators(mockFilterConfig);
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS)).thenReturn("");
  assertTrue(processorsFactory.getPreProcessors().isEmpty());
}
