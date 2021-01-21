public void testModifyIndexDefinitionWithoutPermission4() throws Exception {
  Node indexDef=superuser.getNode(path).addNode(IndexConstants.INDEX_DEFINITIONS_NAME).addNode("myIndex",IndexConstants.INDEX_DEFINITIONS_NODE_TYPE);
  indexDef.setProperty(IndexConstants.TYPE_PROPERTY_NAME,"myType");
  indexDef.setProperty("customProp","val");
  superuser.save();
  allow(path,privilegesFromName(PrivilegeConstants.REP_WRITE));
  try {
    Node n=testSession.getNode(path).getNode(IndexConstants.INDEX_DEFINITIONS_NAME).getNode("myIndex");
    n.getProperty("customProp").remove();
    testSession.save();
    fail("AccessDeniedException expected. Test session is not allowed to remove index definition property.");
  }
 catch (  AccessDeniedException e) {
  }
}
