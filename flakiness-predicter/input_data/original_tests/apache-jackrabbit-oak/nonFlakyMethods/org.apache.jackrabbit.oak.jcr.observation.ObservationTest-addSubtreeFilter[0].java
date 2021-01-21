@Test public void addSubtreeFilter() throws RepositoryException, ExecutionException, InterruptedException {
  assumeTrue(observationManager instanceof ObservationManagerImpl);
  ObservationManagerImpl oManager=(ObservationManagerImpl)observationManager;
  ExpectationListener listener=new ExpectationListener();
  FilterBuilder builder=new FilterBuilder();
  builder.condition(builder.addSubtree());
  oManager.addEventListener(listener,builder.build());
  Node testNode=getNode(TEST_PATH);
  Node a=listener.expectAdd(testNode.addNode("a"));
  a.addNode("c");
  testNode.getSession().save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
