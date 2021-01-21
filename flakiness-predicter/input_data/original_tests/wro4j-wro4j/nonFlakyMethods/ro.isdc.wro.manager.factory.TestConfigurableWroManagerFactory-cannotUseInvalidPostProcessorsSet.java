@Test(expected=WroRuntimeException.class) public void cannotUseInvalidPostProcessorsSet(){
  createManager();
  configureValidUriLocators(mockFilterConfig);
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS)).thenReturn("INVALID1,INVALID2");
  processorsFactory.getPostProcessors();
}
