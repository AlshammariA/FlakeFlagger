@Test public void shouldUseServletContextOnlyLocator(){
  victim.setProperties(createPropsWithLocators(ServletContextUriLocator.ALIAS_SERVLET_CONTEXT_ONLY));
  final List<UriLocator> locators=victim.getConfiguredStrategies();
  assertEquals(1,locators.size());
  assertEquals(ServletContextUriLocator.class,locators.iterator().next().getClass());
}
