public void testReferenceableChild() throws RepositoryException {
  Node node=testRootNode.addNode(nodeName1,ntUnstructured);
  node.addMixin(mixVersionable);
  Node child=node.addNode(nodeName2,ntUnstructured);
  child.addMixin(mixReferenceable);
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  vMgr.checkin(node.getPath());
}
