@Test public void shouldOverrideAvailableLocator(){
  victim=new ConfigurableLocatorFactory(){
    @Override protected void overrideDefaultStrategyMap(    final Map<String,UriLocator> map){
      map.clear();
      map.put(ServletContextUriLocator.ALIAS,mockUriLocator);
    }
  }
;
  final String locatorsAsString=ConfigurableLocatorFactory.createItemsAsString(ServletContextUriLocator.ALIAS);
  victim.setProperties(createPropsWithLocators(locatorsAsString));
  final List<UriLocator> locators=victim.getConfiguredStrategies();
  assertEquals(1,locators.size());
  final Iterator<UriLocator> iterator=locators.iterator();
  assertSame(mockUriLocator,iterator.next());
}
