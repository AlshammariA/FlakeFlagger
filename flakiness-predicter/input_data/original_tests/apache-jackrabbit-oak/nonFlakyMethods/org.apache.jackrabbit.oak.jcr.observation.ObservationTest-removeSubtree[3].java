@Test public void removeSubtree() throws RepositoryException, ExecutionException, InterruptedException {
  Node n=getNode(TEST_PATH);
  n.addNode("a").addNode("b").addNode("c");
  getAdminSession().save();
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,null,null,false);
  listener.expectRemove(n.getNode("a")).remove();
  getAdminSession().save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
