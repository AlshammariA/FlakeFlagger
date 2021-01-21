@Test public void observationDisposeFromListener() throws RepositoryException, InterruptedException, ExecutionException, TimeoutException {
  final ExpectationListener listener=new ExpectationListener();
  Expectation unregistered=listener.expect(new Expectation("Unregistering listener from event handler should not block"){
    @Override public boolean onEvent(    Event event) throws Exception {
      observationManager.removeEventListener(listener);
      return true;
    }
  }
);
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,null,null,false);
  assertTrue(observationManager.getRegisteredEventListeners().hasNext());
  Node n=getNode(TEST_PATH);
  n.addNode("c");
  n.getSession().save();
  assertNotNull(unregistered.get(TIME_OUT,TimeUnit.SECONDS));
  assertFalse(observationManager.getRegisteredEventListeners().hasNext());
}
