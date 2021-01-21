/** 
 * Proves that even if the get() is invoked more times, the check is performed only after a certain period of time.
 */
@Test public void shouldCheckOnlyAfterTimeout() throws Exception {
  final long updatePeriod=10;
  final long delta=5;
  Context.get().getConfig().setResourceWatcherUpdatePeriod(updatePeriod);
  final CacheKey key=new CacheKey("g1",ResourceType.JS,true);
  final long start=System.currentTimeMillis();
  do {
    victim.get(key);
  }
 while (System.currentTimeMillis() - start < updatePeriod - delta);
  Mockito.verify(mockResourceWatcher,times(1)).check(key);
}
