@Test public void testRename() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  superuser.save();
  String destPath=testRoot + '/' + nodeName2;
  move(node1.getPath(),destPath,true);
  assertEquals(destPath,node1.getPath());
}
