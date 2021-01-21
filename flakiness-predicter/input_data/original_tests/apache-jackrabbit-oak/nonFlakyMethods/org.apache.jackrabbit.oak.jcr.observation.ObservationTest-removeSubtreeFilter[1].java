@Test public void removeSubtreeFilter() throws RepositoryException, ExecutionException, InterruptedException {
  assumeTrue(observationManager instanceof ObservationManagerImpl);
  Node testNode=getNode(TEST_PATH);
  testNode.addNode("a").addNode("c");
  testNode.getSession().save();
  ObservationManagerImpl oManager=(ObservationManagerImpl)observationManager;
  ExpectationListener listener=new ExpectationListener();
  FilterBuilder builder=new FilterBuilder();
  builder.condition(builder.deleteSubtree());
  oManager.addEventListener(listener,builder.build());
  listener.expectRemove(testNode.getNode("a")).remove();
  testNode.getSession().save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
