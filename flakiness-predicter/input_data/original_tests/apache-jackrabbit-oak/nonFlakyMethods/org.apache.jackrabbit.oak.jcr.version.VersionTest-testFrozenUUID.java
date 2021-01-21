public void testFrozenUUID() throws RepositoryException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  Node child=n.addNode(nodeName2,"nt:folder");
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  Version v=vMgr.checkpoint(n.getPath());
  vMgr.checkpoint(n.getPath());
  Version baseVersion=vMgr.getBaseVersion(n.getPath());
  Node frozenChild=baseVersion.getFrozenNode().getNode(child.getName());
  assertEquals(child.getIdentifier(),frozenChild.getProperty(Property.JCR_FROZEN_UUID).getString());
  vMgr.restore(v,true);
}
