@Test public void observation() throws RepositoryException, ExecutionException, InterruptedException {
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,null,null,false);
  try {
    Node n=getNode(TEST_PATH);
    listener.expectAdd(n.setProperty("p0","v0"));
    Node n1=listener.expectAdd(n.addNode("n1"));
    listener.expectAdd(n1.setProperty("p1","v1"));
    listener.expectAdd(n1.setProperty("p2","v2"));
    listener.expectAdd(n.addNode("n2"));
    getAdminSession().save();
    List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
    assertTrue("Missing events: " + missing,missing.isEmpty());
    List<Event> unexpected=listener.getUnexpected();
    assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
    listener.expectAdd(n.setProperty("property",42));
    Node n3=listener.expectAdd(n.addNode("n3"));
    listener.expectAdd(n3.setProperty("p3","v3"));
    listener.expectChange(n1.setProperty("p1","v1.1"));
    listener.expectRemove(n1.getProperty("p2")).remove();
    listener.expectRemove(n.getNode("n2")).remove();
    listener.expectAdd(n.addNode("{4}"));
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
