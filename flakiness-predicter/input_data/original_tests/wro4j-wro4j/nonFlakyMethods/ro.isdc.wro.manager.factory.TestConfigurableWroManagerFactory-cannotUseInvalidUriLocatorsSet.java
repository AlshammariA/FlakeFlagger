@Test(expected=WroRuntimeException.class) public void cannotUseInvalidUriLocatorsSet(){
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableLocatorFactory.PARAM_URI_LOCATORS)).thenReturn("INVALID1,INVALID2");
  createManager();
  uriLocatorFactory.getConfiguredStrategies();
}
