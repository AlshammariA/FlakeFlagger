@Test public void testRenameNewNode() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  String destPath=testRoot + '/' + nodeName2;
  move(node1.getPath(),destPath,false);
  assertEquals(destPath,node1.getPath());
}
