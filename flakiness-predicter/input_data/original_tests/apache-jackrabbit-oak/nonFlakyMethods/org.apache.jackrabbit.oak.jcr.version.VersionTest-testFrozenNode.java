public void testFrozenNode() throws RepositoryException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  Node child=n.addNode(nodeName2,ntUnstructured);
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  vMgr.checkpoint(n.getPath());
  Version v=vMgr.getBaseVersion(n.getPath());
  Node frozenChild=v.getFrozenNode().getNode(child.getName());
  assertEquals(ntFrozenNode,frozenChild.getPrimaryNodeType().getName());
}
