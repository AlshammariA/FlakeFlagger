@Test public void moveSubtree() throws RepositoryException, ExecutionException, InterruptedException {
  Node n=getNode(TEST_PATH);
  n.addNode("a").addNode("b").addNode("c");
  getAdminSession().save();
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,null,null,false);
  getAdminSession().move(TEST_PATH + "/a",TEST_PATH + "/t");
  listener.expect(TEST_PATH + "/t",NODE_MOVED);
  listener.expect(TEST_PATH + "/a",NODE_REMOVED);
  listener.expect(TEST_PATH + "/a/jcr:primaryType",PROPERTY_REMOVED);
  listener.expect(TEST_PATH + "/t",NODE_ADDED);
  getAdminSession().save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
