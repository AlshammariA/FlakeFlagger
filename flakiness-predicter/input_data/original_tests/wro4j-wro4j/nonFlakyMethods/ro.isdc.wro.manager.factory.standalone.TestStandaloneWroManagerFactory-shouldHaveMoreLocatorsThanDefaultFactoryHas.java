@Test public void shouldHaveMoreLocatorsThanDefaultFactoryHas(){
  final UriLocatorFactory locatorFactory=victim.newUriLocatorFactory();
  final List<?> availableLocators=((SimpleUriLocatorFactory)locatorFactory).getUriLocators();
  final List<?> defaultLocators=new DefaultUriLocatorFactory().getUriLocators();
  Assert.assertTrue(availableLocators.size() > defaultLocators.size());
}
