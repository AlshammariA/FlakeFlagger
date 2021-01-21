@SuppressWarnings("deprecation") public void testGetNodeByUUID() throws RepositoryException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  String uuid=vMgr.getBaseVersion(n.getPath()).getUUID();
  assertTrue("Session.getNodeByUUID() did not return Version object for a nt:version node.",superuser.getNodeByUUID(uuid) instanceof Version);
}
