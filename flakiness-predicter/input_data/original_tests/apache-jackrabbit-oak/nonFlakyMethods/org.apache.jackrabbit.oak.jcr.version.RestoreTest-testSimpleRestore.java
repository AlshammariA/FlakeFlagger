public void testSimpleRestore() throws RepositoryException {
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  n.setProperty("prop","a");
  superuser.save();
  String path=n.getPath();
  Version v=vMgr.checkpoint(path);
  n.setProperty("prop","b");
  superuser.save();
  vMgr.checkpoint(path);
  n.remove();
  superuser.save();
  vMgr.restore(path,v,true);
  assertTrue(superuser.nodeExists(path));
  n=superuser.getNode(path);
  assertEquals("Property not restored","a",n.getProperty("prop").getString());
  Property vhProp=n.getProperty(jcrVersionHistory);
  assertEquals(PropertyType.REFERENCE,vhProp.getType());
  PropertyDefinition def=vhProp.getDefinition();
  assertEquals(PropertyType.REFERENCE,def.getRequiredType());
}
