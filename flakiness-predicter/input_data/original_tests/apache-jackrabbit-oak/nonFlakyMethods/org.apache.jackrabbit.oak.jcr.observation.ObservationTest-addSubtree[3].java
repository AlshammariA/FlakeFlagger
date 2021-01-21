@Test public void addSubtree() throws RepositoryException, ExecutionException, InterruptedException {
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,null,null,false);
  Node n=getNode(TEST_PATH);
  Node a=listener.expectAdd(n.addNode("a"));
  Node b=listener.expectAdd(a.addNode("b"));
  listener.expectAdd(b.addNode("c"));
  getAdminSession().save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
