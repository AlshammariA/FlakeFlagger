public void testJcrVersionHistoryProperty() throws Exception {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  assertTrue(n.hasProperty(JcrConstants.JCR_VERSIONHISTORY));
}
