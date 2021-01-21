@Test public void shouldBeFasterWhenRunningMultipleSlowTasks() throws Exception {
  final Collection<Callable<Void>> callables=new ArrayList<Callable<Void>>();
  final long delay=100;
  final int times=10;
  for (int i=0; i < times; i++) {
    callables.add(createSlowCallable(delay));
  }
  final long start=System.currentTimeMillis();
  victim.submit(callables);
  final long end=System.currentTimeMillis();
  final long delta=end - start;
  LOG.debug("Execution took: {}",delta);
  assertTrue(delta < delay * times);
}
