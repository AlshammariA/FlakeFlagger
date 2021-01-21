public void testVersionableIndexDefinition() throws Exception {
  allow(path,privilegesFromNames(new String[]{PrivilegeConstants.REP_INDEX_DEFINITION_MANAGEMENT,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  try {
    Node n=testSession.getNode(path).addNode(IndexConstants.INDEX_DEFINITIONS_NAME).addNode("myIndex",IndexConstants.INDEX_DEFINITIONS_NODE_TYPE);
    n.setProperty(IndexConstants.TYPE_PROPERTY_NAME,"myType");
    n.addMixin(JcrConstants.MIX_VERSIONABLE);
    testSession.save();
    fail("Missing rep:versionManagement privilege");
  }
 catch (  AccessDeniedException e) {
  }
}
