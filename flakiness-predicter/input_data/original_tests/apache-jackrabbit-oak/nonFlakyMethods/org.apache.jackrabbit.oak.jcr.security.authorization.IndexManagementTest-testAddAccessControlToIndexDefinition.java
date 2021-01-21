public void testAddAccessControlToIndexDefinition() throws Exception {
  allow(path,privilegesFromNames(new String[]{PrivilegeConstants.REP_INDEX_DEFINITION_MANAGEMENT,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  try {
    Node n=testSession.getNode(path).addNode(IndexConstants.INDEX_DEFINITIONS_NAME).addNode("myIndex",IndexConstants.INDEX_DEFINITIONS_NODE_TYPE);
    n.setProperty(IndexConstants.TYPE_PROPERTY_NAME,"myType");
    AccessControlUtils.addAccessControlEntry(testSession,n.getPath(),testUser.getPrincipal(),new String[]{PrivilegeConstants.JCR_ALL},true);
    testSession.save();
    fail("Missing rep:modifyAccessControl privilege");
  }
 catch (  AccessDeniedException e) {
  }
}
