@Test public void identifier() throws RepositoryException, InterruptedException, ExecutionException {
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,NODE_ADDED,TEST_PATH,true,null,null,false);
  try {
    Node n=getNode(TEST_PATH);
    listener.expect(new Expectation("Has correct id"){
      @Override public boolean onEvent(      Event event) throws Exception {
        return (TEST_PATH + "/newNode").equals(event.getIdentifier());
      }
    }
);
    n.addNode("newNode");
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
