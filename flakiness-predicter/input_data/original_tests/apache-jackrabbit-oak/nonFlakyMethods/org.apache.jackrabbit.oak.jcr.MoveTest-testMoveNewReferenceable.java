@Test public void testMoveNewReferenceable() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  node1.addMixin(JcrConstants.MIX_REFERENCEABLE);
  assertTrue(node1.isNodeType(JcrConstants.MIX_REFERENCEABLE));
  Node node2=testRootNode.addNode(nodeName2);
  String destPath=node2.getPath() + '/' + nodeName1;
  move(node1.getPath(),destPath,false);
  assertEquals(destPath,node1.getPath());
  superuser.save();
  assertEquals(destPath,node1.getPath());
}
