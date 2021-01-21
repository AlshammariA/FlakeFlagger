@Test public void shouldLoadUriLocatorsFromConfigurationFile(){
  configProperties.setProperty(ConfigurableLocatorFactory.PARAM_URI_LOCATORS,"servletContext");
  createManager();
  assertEquals(1,uriLocatorFactory.getConfiguredStrategies().size());
  assertSame(ServletContextUriLocator.class,uriLocatorFactory.getConfiguredStrategies().iterator().next().getClass());
}
