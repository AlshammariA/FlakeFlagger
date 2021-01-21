public void testGetVersionHistoryNodeByUUID() throws Exception {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  Node vh=superuser.getNodeByUUID(n.getProperty(JcrConstants.JCR_VERSIONHISTORY).getString());
  assertNotNull(vh);
}
