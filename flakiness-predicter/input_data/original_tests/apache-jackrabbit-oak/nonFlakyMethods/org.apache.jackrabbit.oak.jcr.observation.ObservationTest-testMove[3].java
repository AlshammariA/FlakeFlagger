@Test public void testMove() throws RepositoryException, ExecutionException, InterruptedException {
  Node testNode=getNode(TEST_PATH);
  Session session=testNode.getSession();
  Node nodeA=testNode.addNode("a");
  Node nodeAA=nodeA.addNode("aa");
  Node nodeT=testNode.addNode("t");
  Node nodeS=testNode.addNode("s");
  session.save();
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,NODE_MOVED,"/",true,null,null,false);
  String src1=nodeA.getPath();
  String dst1=nodeT.getPath() + "/b";
  session.move(src1,dst1);
  listener.expectMove(src1,dst1);
  String src2=nodeT.getPath() + "/b/aa";
  String dst2=nodeS.getPath() + "/bb";
  session.move(src2,dst2);
  listener.expectMove(src1 + "/aa",dst2);
  session.save();
  List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
  assertTrue("Missing events: " + missing,missing.isEmpty());
  List<Event> unexpected=listener.getUnexpected();
  assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
}
