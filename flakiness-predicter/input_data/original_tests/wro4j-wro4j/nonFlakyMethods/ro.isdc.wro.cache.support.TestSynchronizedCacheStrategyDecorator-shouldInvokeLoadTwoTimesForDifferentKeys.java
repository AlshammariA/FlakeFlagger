@Test public void shouldInvokeLoadTwoTimesForDifferentKeys() throws Exception {
  final AtomicInteger count=createSlowCountingDecorator();
  final String key1="key1";
  final String key2="key2";
  executor.execute(getRunnableForKey(key1));
  executor.execute(getRunnableForKey(key1));
  executor.execute(getRunnableForKey(key2));
  executor.execute(getRunnableForKey(key1));
  executor.execute(getRunnableForKey(key2));
  executor.execute(getRunnableForKey(key1));
  executor.execute(getRunnableForKey(key2));
  executor.execute(getRunnableForKey(key1));
  awaitTermination();
  Assert.assertEquals(2,count.get());
}
