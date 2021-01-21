@Test public void filterDisjunctPaths() throws ExecutionException, InterruptedException, RepositoryException {
  assumeTrue(observationManager instanceof ObservationManagerImpl);
  ObservationManagerImpl oManager=(ObservationManagerImpl)observationManager;
  ExpectationListener listener=new ExpectationListener();
  FilterBuilder builder=new FilterBuilder();
  builder.condition(builder.any(builder.path(TEST_PATH + "/a/b"),builder.path(TEST_PATH + "/x/y")));
  oManager.addEventListener(listener,builder.build());
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
