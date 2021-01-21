@Test public void shouldLoadUriLocatorsFromFilterConfigRatherThanFromConfigProperties(){
  configProperties.setProperty(ConfigurableLocatorFactory.PARAM_URI_LOCATORS,"servletContext");
  Mockito.when(mockFilterConfig.getInitParameter(ConfigurableLocatorFactory.PARAM_URI_LOCATORS)).thenReturn("classpath, servletContext");
  createManager();
  assertEquals(2,uriLocatorFactory.getConfiguredStrategies().size());
  final Iterator<UriLocator> locatorsIterator=uriLocatorFactory.getConfiguredStrategies().iterator();
  assertSame(ClasspathUriLocator.class,locatorsIterator.next().getClass());
  assertSame(ServletContextUriLocator.class,locatorsIterator.next().getClass());
}
