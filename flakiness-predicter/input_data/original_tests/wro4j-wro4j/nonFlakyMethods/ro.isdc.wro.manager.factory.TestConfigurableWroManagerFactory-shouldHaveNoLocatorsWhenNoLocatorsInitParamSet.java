@Test public void shouldHaveNoLocatorsWhenNoLocatorsInitParamSet(){
  createManager();
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableLocatorFactory.PARAM_URI_LOCATORS)).thenReturn("");
  assertTrue(uriLocatorFactory.getConfiguredStrategies().isEmpty());
}
