public void testGetVersionHistory() throws Exception {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  VersionHistory vh=versionManager.getVersionHistory(n.getPath());
  assertNotNull(vh);
}
