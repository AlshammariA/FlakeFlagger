public void testGetTypeOfPredecessors() throws RepositoryException {
  Node node=testRootNode.addNode(nodeName1,testNodeType);
  node.addMixin(mixVersionable);
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  vMgr.checkin(node.getPath());
  assertEquals(PropertyType.nameFromValue(PropertyType.REFERENCE),PropertyType.nameFromValue(node.getProperty(jcrPredecessors).getType()));
}
