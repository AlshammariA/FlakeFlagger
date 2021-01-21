/** 
 * Exceptional flow for issue751.
 */
@Test(expected=WroRuntimeException.class) public void shouldFailWhenInvalidModelIsProvidedWhenUsingConfigurableWroManagerFactory(){
  useModelFactoryWithAlias("invalidModel");
}
