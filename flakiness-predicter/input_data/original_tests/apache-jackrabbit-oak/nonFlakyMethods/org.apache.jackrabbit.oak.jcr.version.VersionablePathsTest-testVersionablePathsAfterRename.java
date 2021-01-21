public void testVersionablePathsAfterRename() throws Exception {
  Node node1=testRootNode.addNode(nodeName1);
  node1.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  String destPath=testRoot + "/" + nodeName2;
  superuser.move(node1.getPath(),destPath);
  superuser.save();
  Node vh=getVersionManager().getVersionHistory(node1.getPath());
  assertTrue(vh.isNodeType("rep:VersionablePaths"));
  String workspaceName=superuser.getWorkspace().getName();
  assertTrue(vh.hasProperty(workspaceName));
  assertEquals(node1.getPath(),vh.getProperty(workspaceName).getString());
}
