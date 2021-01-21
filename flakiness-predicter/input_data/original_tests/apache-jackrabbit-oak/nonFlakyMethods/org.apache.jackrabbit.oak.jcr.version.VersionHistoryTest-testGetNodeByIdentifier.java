public void testGetNodeByIdentifier() throws RepositoryException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  String id=vMgr.getVersionHistory(n.getPath()).getIdentifier();
  assertTrue("Session.getNodeByIdentifier() did not return VersionHistory object for a nt:versionHistory node.",superuser.getNodeByIdentifier(id) instanceof VersionHistory);
}
