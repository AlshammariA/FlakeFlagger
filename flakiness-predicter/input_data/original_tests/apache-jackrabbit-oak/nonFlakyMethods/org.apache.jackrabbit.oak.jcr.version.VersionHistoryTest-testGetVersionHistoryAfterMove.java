public void testGetVersionHistoryAfterMove() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  node1.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  Node node2=testRootNode.addNode(nodeName2);
  String destPath=node2.getPath() + "/" + nodeName3;
  superuser.move(node1.getPath(),destPath);
  superuser.save();
  assertTrue(superuser.nodeExists(destPath));
  VersionHistory vh=versionManager.getVersionHistory(destPath);
}
