@Test public void shouldDetectConfiguredLocators(){
  final String locatorsAsString=ConfigurableLocatorFactory.createItemsAsString(ServletContextUriLocator.ALIAS_DISPATCHER_FIRST,ServletContextUriLocator.ALIAS_SERVLET_CONTEXT_FIRST,ServletContextUriLocator.ALIAS,ClasspathUriLocator.ALIAS,UrlUriLocator.ALIAS);
  victim.setProperties(createPropsWithLocators(locatorsAsString));
  final List<UriLocator> locators=victim.getConfiguredStrategies();
  assertEquals(5,locators.size());
  final Iterator<UriLocator> iterator=locators.iterator();
  assertEquals(ServletContextUriLocator.class,iterator.next().getClass());
  assertEquals(ServletContextUriLocator.class,iterator.next().getClass());
  assertEquals(ServletContextUriLocator.class,iterator.next().getClass());
  assertEquals(ClasspathUriLocator.class,iterator.next().getClass());
  assertEquals(UrlUriLocator.class,iterator.next().getClass());
}
