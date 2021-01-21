/** 
 * When no uri locators are set, the default factory is used.
 */
@Test public void shouldHaveNoLocatorsWhenNoUriLocatorsParamSet(){
  createManager();
  assertTrue(uriLocatorFactory.getConfiguredStrategies().isEmpty());
}
