@Test public void shouldHaveCorrectLocatorsSet(){
  configureValidUriLocators(mockFilterConfig);
  createManager();
  assertEquals(3,uriLocatorFactory.getConfiguredStrategies().size());
}
