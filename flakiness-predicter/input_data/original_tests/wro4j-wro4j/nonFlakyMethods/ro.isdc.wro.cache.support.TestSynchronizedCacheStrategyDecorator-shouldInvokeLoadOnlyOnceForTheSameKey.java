@Test public void shouldInvokeLoadOnlyOnceForTheSameKey() throws Exception {
  final AtomicInteger count=createSlowCountingDecorator();
  final String key="key";
  executor.execute(getRunnableForKey(key));
  executor.execute(getRunnableForKey(key));
  executor.execute(getRunnableForKey(key));
  executor.execute(getRunnableForKey(key));
  executor.execute(getRunnableForKey(key));
  awaitTermination();
  Assert.assertEquals(1,count.get());
}
