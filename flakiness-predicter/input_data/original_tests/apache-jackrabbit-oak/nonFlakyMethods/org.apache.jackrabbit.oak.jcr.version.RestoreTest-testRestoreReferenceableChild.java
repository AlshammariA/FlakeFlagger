public void testRestoreReferenceableChild() throws RepositoryException {
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  Node n=testRootNode.addNode(nodeName1,"test:versionable");
  n.addMixin(mixVersionable);
  n.setProperty("prop","a");
  Node child=n.addNode("test:copyOnParentVersion",ntUnstructured);
  child.addMixin(mixReferenceable);
  child.setProperty("prop","a");
  superuser.save();
  String path=n.getPath();
  Version v=vMgr.checkpoint(path);
  n.setProperty("prop","b");
  child.setProperty("prop","b");
  superuser.save();
  vMgr.checkpoint(path);
  vMgr.restore(v,true);
  assertEquals("Property not restored","a",n.getProperty("prop").getString());
  assertEquals("Property not restored","a",child.getProperty("prop").getString());
  assertFalse("Restored node must not have jcr:frozenPrimaryType property",child.hasProperty(JcrConstants.JCR_FROZENPRIMARYTYPE));
}
