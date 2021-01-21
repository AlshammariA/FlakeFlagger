@Test public void shouldNotCheckForChangesWhenResourceWatcherPeriodIsNotSet() throws Exception {
  final CacheKey key=new CacheKey("g1",ResourceType.JS,true);
  victim.get(key);
  victim.get(key);
  Mockito.verify(mockResourceWatcher,never()).check(key);
}
