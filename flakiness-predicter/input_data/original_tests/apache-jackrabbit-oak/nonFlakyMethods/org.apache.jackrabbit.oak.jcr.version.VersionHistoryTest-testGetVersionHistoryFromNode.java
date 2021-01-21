public void testGetVersionHistoryFromNode() throws Exception {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  VersionHistory vh=n.getVersionHistory();
  assertNotNull(vh);
}
