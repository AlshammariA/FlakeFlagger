@Test public void shouldUseDefaultLocatorWhenNoneIsConfigured(){
  final UriLocator locator=victim.getInstance("/");
  assertEquals(ServletContextUriLocator.class,locator.getClass());
}
