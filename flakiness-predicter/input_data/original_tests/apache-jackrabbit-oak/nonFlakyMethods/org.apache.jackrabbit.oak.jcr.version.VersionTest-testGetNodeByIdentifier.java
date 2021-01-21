public void testGetNodeByIdentifier() throws RepositoryException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  String id=vMgr.getBaseVersion(n.getPath()).getIdentifier();
  assertTrue("Session.getNodeByIdentifier() did not return Version object for a nt:version node.",superuser.getNodeByIdentifier(id) instanceof Version);
}
