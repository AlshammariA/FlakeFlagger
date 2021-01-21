@Test public void shouldHaveMinimalOverheadWhenRunningASingleTask() throws Exception {
  final Collection<Callable<Void>> callables=new ArrayList<Callable<Void>>();
  final long delay=100;
  callables.add(createSlowCallable(delay));
  final long start=System.currentTimeMillis();
  victim.submit(callables);
  final long end=System.currentTimeMillis();
  final long delta=end - start;
  LOG.debug("Execution took: {}",delta);
  final long overhead=40;
  assertTrue(delta < delay + overhead);
}
