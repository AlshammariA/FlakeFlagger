@Test public void shouldNotFailWhenNoResourcesProcessed() throws Exception {
  initExecutor(createProcessorUsingMissingResource());
  victim.processAndMerge(createResources(),true);
}
