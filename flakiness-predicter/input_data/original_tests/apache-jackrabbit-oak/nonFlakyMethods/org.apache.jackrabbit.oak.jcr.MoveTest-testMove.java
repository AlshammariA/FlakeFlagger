@Test public void testMove() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  Node node2=testRootNode.addNode(nodeName2);
  superuser.save();
  String destPath=node2.getPath() + '/' + nodeName1;
  move(node1.getPath(),destPath,true);
  assertEquals(destPath,node1.getPath());
}
