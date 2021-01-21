public void testGetVersionHistory2() throws Exception {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  Session s=getHelper().getSuperuserSession();
  try {
    VersionHistory vh=s.getWorkspace().getVersionManager().getVersionHistory(n.getPath());
    assertNotNull(vh);
  }
  finally {
    s.logout();
  }
}
