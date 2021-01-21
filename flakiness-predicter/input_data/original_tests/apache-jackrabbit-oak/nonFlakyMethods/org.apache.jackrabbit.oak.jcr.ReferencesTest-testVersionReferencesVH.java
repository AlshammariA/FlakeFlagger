public void testVersionReferencesVH() throws RepositoryException {
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  superuser.save();
  String p=n.getPath();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  VersionHistory vh=vMgr.getVersionHistory(p);
  assertEquals("Version History",vh.getIdentifier(),n.getProperty(Property.JCR_VERSION_HISTORY).getString());
  checkReferences("Version History",vh.getReferences(),p + "/jcr:versionHistory");
}
