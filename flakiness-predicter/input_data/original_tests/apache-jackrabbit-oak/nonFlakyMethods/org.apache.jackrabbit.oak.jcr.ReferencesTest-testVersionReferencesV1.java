public void testVersionReferencesV1() throws RepositoryException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  superuser.save();
  String p=n.getPath();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  Version v1=vMgr.checkpoint(p);
  assertEquals("v1.0",v1.getIdentifier(),n.getProperty(Property.JCR_BASE_VERSION).getString());
  assertEquals("v1.0",v1.getIdentifier(),n.getProperty(Property.JCR_PREDECESSORS).getValues()[0].getString());
  checkReferences("v1.0",v1.getReferences(),p + "/jcr:baseVersion",p + "/jcr:predecessors");
}
