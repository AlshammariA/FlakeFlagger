@Test public void shouldUseOverridenNamingStrategyMap(){
  final String mockAlias="mock";
  victim=new ConfigurableNamingStrategy(){
    @Override protected void overrideDefaultStrategyMap(    final Map<String,NamingStrategy> map){
      map.put(mockAlias,mockNamingStrategy);
    }
  }
;
  victim.setProperties(buildPropsForAlias(mockAlias));
  final NamingStrategy actual=victim.getConfiguredStrategy();
  Assert.assertSame(mockNamingStrategy,actual);
}
