@Test public void uuidFilter() throws RepositoryException, InterruptedException, ExecutionException {
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,new String[]{test_uuid},null,false);
  try {
    Node nonRefNode=getNode(TEST_PATH);
    Node refNode=nonRefNode.getNode(REFERENCEABLE_NODE);
    nonRefNode.addNode("n");
    listener.expect(refNode.addNode("r").getPath(),NODE_ADDED);
    getAdminSession().save();
    List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
    assertTrue("Missing events: " + missing,missing.isEmpty());
    List<Event> unexpected=listener.getUnexpected();
    assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
  }
  finally {
    observationManager.removeEventListener(listener);
  }
}
