@Test public void testWhenValidPostProcessorsSet(){
  createManager();
  configureValidUriLocators(mockFilterConfig);
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS)).thenReturn("cssMinJawr, jsMin, cssVariables");
  assertEquals(3,processorsFactory.getPostProcessors().size());
}
