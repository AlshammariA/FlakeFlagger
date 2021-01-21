@Test public void testMoveNewNode() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  Node node2=testRootNode.addNode(nodeName2);
  String destPath=node2.getPath() + '/' + nodeName1;
  move(node1.getPath(),destPath,false);
  assertEquals(destPath,node1.getPath());
}
