@Test public void filterPropertyOfChild() throws RepositoryException, ExecutionException, InterruptedException {
  assumeTrue(observationManager instanceof ObservationManagerImpl);
  ObservationManagerImpl oManager=(ObservationManagerImpl)observationManager;
  ExpectationListener listener=new ExpectationListener();
  FilterBuilder builder=new FilterBuilder();
  builder.condition(builder.property(Selectors.fromThis("b/c"),"foo",new Predicate<PropertyState>(){
    @Override public boolean apply(    PropertyState property){
      return "bar".equals(property.getValue(STRING));
    }
  }
));
  oManager.addEventListener(listener,builder.build());
  Node testNode=getNode(TEST_PATH);
  Node a=testNode.addNode("a");
  a.addNode("b").addNode("c").setProperty("foo","bar");
  a.addNode("d");
  Node x=testNode.addNode("x");
  x.addNode("b").addNode("c").setProperty("foo","baz");
  x.addNode("d");
  listener.expect(a.getPath(),NODE_ADDED);
  testNode.getSession().save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
