@Test public void testReorder() throws RepositoryException, InterruptedException, ExecutionException {
  Node testNode=getNode(TEST_PATH);
  Node nodeA=testNode.addNode("a","nt:unstructured");
  Node nodeB=testNode.addNode("b","nt:unstructured");
  testNode.getSession().save();
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,NODE_MOVED,"/",true,null,null,false);
  listener.expect(new Expectation("orderBefore"){
    @Override public boolean onEvent(    Event event) throws Exception {
      if (event.getType() != NODE_MOVED || event.getInfo() == null) {
        return false;
      }
      Map<?,?> info=event.getInfo();
      if (PathUtils.concat(TEST_PATH,"a").equals(event.getPath())) {
        return "a".equals(info.get("srcChildRelPath")) && "b".equals(info.get("destChildRelPath"));
      }
 else       if (PathUtils.concat(TEST_PATH,"b").equals(event.getPath())) {
        return "b".equals(info.get("srcChildRelPath")) && "a".equals(info.get("destChildRelPath"));
      }
 else {
        return false;
      }
    }
  }
);
  testNode.orderBefore(nodeA.getName(),null);
  testNode.getSession().save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
