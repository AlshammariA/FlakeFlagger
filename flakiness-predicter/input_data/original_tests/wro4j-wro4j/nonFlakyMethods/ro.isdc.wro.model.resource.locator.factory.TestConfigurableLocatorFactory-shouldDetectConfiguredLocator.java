@Test public void shouldDetectConfiguredLocator(){
  victim.setProperties(createPropsWithLocators(ServletContextUriLocator.ALIAS_DISPATCHER_FIRST));
  final List<UriLocator> locators=victim.getConfiguredStrategies();
  assertEquals(1,locators.size());
  assertEquals(ServletContextUriLocator.class,locators.iterator().next().getClass());
}
