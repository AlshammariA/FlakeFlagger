@Test public void observation2() throws RepositoryException, InterruptedException, ExecutionException {
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,null,null,false);
  try {
    Node n=getNode(TEST_PATH);
    listener.expectAdd(n.addNode("n1"));
    getAdminSession().save();
    List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
    assertTrue("Missing events: " + missing,missing.isEmpty());
    List<Event> unexpected=listener.getUnexpected();
    assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
    listener.expectAdd(n.addNode("n2"));
    listener.expectRemove(n.getNode("n1")).remove();
    getAdminSession().save();
    missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
    assertTrue("Missing events: " + missing,missing.isEmpty());
    unexpected=listener.getUnexpected();
    assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
  }
  finally {
    observationManager.removeEventListener(listener);
  }
}
