@Test public void filterPropertyOfParent() throws RepositoryException, ExecutionException, InterruptedException {
  assumeTrue(observationManager instanceof ObservationManagerImpl);
  ObservationManagerImpl oManager=(ObservationManagerImpl)observationManager;
  ExpectationListener listener=new ExpectationListener();
  FilterBuilder builder=new FilterBuilder();
  builder.condition(builder.property(Selectors.PARENT,"foo",new Predicate<PropertyState>(){
    @Override public boolean apply(    PropertyState property){
      return "bar".equals(property.getValue(STRING));
    }
  }
));
  oManager.addEventListener(listener,builder.build());
  Node testNode=getNode(TEST_PATH);
  Node a=testNode.addNode("a");
  Node x=testNode.addNode("x");
  a.setProperty("foo","bar");
  x.setProperty("foo","baz");
  a.addNode("b");
  x.addNode("y");
  listener.expect(a.getPath() + "/jcr:primaryType",PROPERTY_ADDED);
  listener.expect(a.getPath() + "/foo",PROPERTY_ADDED);
  listener.expect(a.getPath() + "/b",NODE_ADDED);
  testNode.getSession().save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
