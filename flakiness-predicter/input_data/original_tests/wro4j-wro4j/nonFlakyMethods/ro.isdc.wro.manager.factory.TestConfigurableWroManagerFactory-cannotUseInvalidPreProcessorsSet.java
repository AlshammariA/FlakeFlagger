@Test(expected=WroRuntimeException.class) public void cannotUseInvalidPreProcessorsSet(){
  createManager();
  configureValidUriLocators(mockFilterConfig);
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS)).thenReturn("INVALID1,INVALID2");
  processorsFactory.getPreProcessors();
}
