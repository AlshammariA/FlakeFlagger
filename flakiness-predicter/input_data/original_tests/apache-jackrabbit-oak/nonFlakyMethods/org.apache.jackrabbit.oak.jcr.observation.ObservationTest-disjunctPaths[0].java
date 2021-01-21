@Test public void disjunctPaths() throws ExecutionException, InterruptedException, RepositoryException {
  assumeTrue(observationManager instanceof JackrabbitObservationManager);
  JackrabbitObservationManager oManager=(JackrabbitObservationManager)observationManager;
  ExpectationListener listener=new ExpectationListener();
  JackrabbitEventFilter filter=new JackrabbitEventFilter().setAdditionalPaths(TEST_PATH + "/a",TEST_PATH + "/x").setEventTypes(NODE_ADDED);
  oManager.addEventListener(listener,filter);
  Node testNode=getNode(TEST_PATH);
  Node b=testNode.addNode("a").addNode("b");
  b.addNode("c");
  Node y=testNode.addNode("x").addNode("y");
  y.addNode("z");
  listener.expect(b.getPath(),NODE_ADDED);
  listener.expect(y.getPath(),NODE_ADDED);
  testNode.getSession().save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
