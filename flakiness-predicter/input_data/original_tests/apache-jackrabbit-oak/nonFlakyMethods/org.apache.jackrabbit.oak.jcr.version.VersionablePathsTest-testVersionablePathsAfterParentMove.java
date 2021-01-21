public void testVersionablePathsAfterParentMove() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  Node node3=node1.addNode(nodeName3);
  Node node2=testRootNode.addNode(nodeName2);
  node3.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  String destPath=node2.getPath() + '/' + nodeName1;
  superuser.move(node1.getPath(),destPath);
  superuser.save();
  assertEquals(destPath + '/' + nodeName3,node3.getPath());
  Node vh=getVersionManager().getVersionHistory(node3.getPath());
  assertTrue(vh.isNodeType("rep:VersionablePaths"));
  String workspaceName=superuser.getWorkspace().getName();
  assertTrue(vh.hasProperty(workspaceName));
  assertEquals(node3.getPath(),vh.getProperty(workspaceName).getString());
}
