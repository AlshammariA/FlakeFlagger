@Test public void typeFilter() throws RepositoryException, InterruptedException, ExecutionException {
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,null,new String[]{TEST_TYPE},false);
  try {
    Node n=getNode(TEST_PATH);
    Property p=n.setProperty("p","v");
    listener.expectAdd(p);
    Node n1=n.addNode("n1");
    listener.expect(n1.getPath(),NODE_ADDED);
    n1.addNode("n2");
    getAdminSession().save();
    List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
    assertTrue("Missing events: " + missing,missing.isEmpty());
    List<Event> unexpected=listener.getUnexpected();
    assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
    listener.expectChange(p).setValue("v2");
    getAdminSession().save();
    missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
    assertTrue("Missing events: " + missing,missing.isEmpty());
    unexpected=listener.getUnexpected();
    assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
    listener.expectRemove(p).remove();
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
