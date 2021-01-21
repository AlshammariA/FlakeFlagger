public void testVersionablePathsAfterMove() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  Node node2=testRootNode.addNode(nodeName2);
  node1.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  String destPath=node2.getPath() + '/' + nodeName1;
  superuser.move(node1.getPath(),destPath);
  superuser.save();
  assertEquals(destPath,node1.getPath());
  Node vh=getVersionManager().getVersionHistory(node1.getPath());
  assertTrue(vh.isNodeType("rep:VersionablePaths"));
  String workspaceName=superuser.getWorkspace().getName();
  assertTrue(vh.hasProperty(workspaceName));
  assertEquals(node1.getPath(),vh.getProperty(workspaceName).getString());
}
