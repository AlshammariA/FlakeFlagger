@Test public void shouldNotFailWhenASingleProviderFails(){
  victim=new ConfigurableLocatorFactory(){
    @Override protected ProviderFinder<LocatorProvider> getProviderFinder(){
      return mockProviderFinder;
    }
  }
;
  final List<LocatorProvider> providers=new ArrayList<LocatorProvider>();
  providers.add(new LocatorProvider(){
    public Map<String,UriLocator> provideLocators(){
      throw new IllegalStateException("Unexpected BOOM!");
    }
  }
);
  when(mockProviderFinder.find()).thenReturn(providers);
  assertTrue(victim.getAvailableStrategies().isEmpty());
}
