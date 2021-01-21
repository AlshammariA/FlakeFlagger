public void testAddIndexDefinitionWithoutPermission() throws Exception {
  superuser.getNode(path).addNode(IndexConstants.INDEX_DEFINITIONS_NAME);
  superuser.save();
  allow(path,privilegesFromName(PrivilegeConstants.REP_WRITE));
  try {
    Node n=testSession.getNode(path).getNode(IndexConstants.INDEX_DEFINITIONS_NAME).addNode("myIndex",IndexConstants.INDEX_DEFINITIONS_NODE_TYPE);
    n.setProperty(IndexConstants.TYPE_PROPERTY_NAME,"myType");
    testSession.save();
    fail("AccessDeniedException expected. Test session is not allowed to add index definition node.");
  }
 catch (  AccessDeniedException e) {
  }
}
