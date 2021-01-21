public void testVersionReferencesV0() throws RepositoryException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  superuser.save();
  String p=n.getPath();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  Version v0=vMgr.getVersionHistory(p).getRootVersion();
  assertEquals("Root Version",v0.getIdentifier(),n.getProperty(Property.JCR_BASE_VERSION).getString());
  assertEquals("Root Version",v0.getIdentifier(),n.getProperty(Property.JCR_PREDECESSORS).getValues()[0].getString());
  checkReferences("Root Version",v0.getReferences(),p + "/jcr:baseVersion",p + "/jcr:predecessors");
}
