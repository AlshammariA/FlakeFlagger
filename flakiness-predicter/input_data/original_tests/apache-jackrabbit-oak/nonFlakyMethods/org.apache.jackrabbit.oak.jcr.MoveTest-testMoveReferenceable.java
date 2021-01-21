@Test public void testMoveReferenceable() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  node1.addMixin(JcrConstants.MIX_REFERENCEABLE);
  Node node2=testRootNode.addNode(nodeName2);
  superuser.save();
  String destPath=node2.getPath() + '/' + nodeName1;
  move(node1.getPath(),destPath,true);
  assertEquals(destPath,node1.getPath());
}
