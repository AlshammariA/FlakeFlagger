@Test public void testWithEmptyPostProcessors(){
  createManager();
  configureValidUriLocators(mockFilterConfig);
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS)).thenReturn("");
  assertTrue(processorsFactory.getPostProcessors().isEmpty());
}
