@Test public void shouldComputeCorrectlyAvailableStrategiesDependingOnProviderFinder(){
  victim=new ConfigurableLocatorFactory(){
    @Override protected ProviderFinder<LocatorProvider> getProviderFinder(){
      return mockProviderFinder;
    }
  }
;
  when(mockProviderFinder.find()).thenReturn(new ArrayList<LocatorProvider>());
  assertTrue(victim.getAvailableStrategies().isEmpty());
  final List<LocatorProvider> providers=new ArrayList<LocatorProvider>();
  providers.add(new LocatorProvider(){
    public Map<String,UriLocator> provideLocators(){
      final Map<String,UriLocator> map=new HashMap<String,UriLocator>();
      map.put("first",mockUriLocator);
      map.put("second",mockUriLocator);
      return map;
    }
  }
);
  victim=new ConfigurableLocatorFactory(){
    @Override protected ProviderFinder<LocatorProvider> getProviderFinder(){
      return mockProviderFinder;
    }
  }
;
  when(mockProviderFinder.find()).thenReturn(providers);
  assertEquals(2,victim.getAvailableStrategies().size());
  assertEquals("[first, second]",victim.getAvailableAliases().toString());
}
