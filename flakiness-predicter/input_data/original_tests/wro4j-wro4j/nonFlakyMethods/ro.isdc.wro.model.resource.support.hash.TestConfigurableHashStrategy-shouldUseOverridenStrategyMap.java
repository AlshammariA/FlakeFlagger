@Test public void shouldUseOverridenStrategyMap(){
  final String mockAlias="mock";
  victim=new ConfigurableHashStrategy(){
    @Override protected void overrideDefaultStrategyMap(    final Map<String,HashStrategy> map){
      map.put(mockAlias,mockHashStrategy);
    }
  }
;
  victim.setProperties(buildPropsForAlias(mockAlias));
  final HashStrategy actual=victim.getConfiguredStrategy();
  Assert.assertSame(mockHashStrategy,actual);
}
