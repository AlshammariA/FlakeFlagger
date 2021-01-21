@SuppressWarnings("deprecation") public void testGetNodeByUUID() throws RepositoryException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  String uuid=vMgr.getVersionHistory(n.getPath()).getUUID();
  assertTrue("Session.getNodeByUUID() did not return VersionHistory object for a nt:versionHistory node.",superuser.getNodeByUUID(uuid) instanceof VersionHistory);
}
