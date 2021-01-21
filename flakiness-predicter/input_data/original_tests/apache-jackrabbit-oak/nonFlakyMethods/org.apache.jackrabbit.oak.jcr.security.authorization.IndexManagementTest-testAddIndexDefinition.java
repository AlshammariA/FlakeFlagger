public void testAddIndexDefinition() throws Exception {
  superuser.getNode(path).addNode(IndexConstants.INDEX_DEFINITIONS_NAME);
  superuser.save();
  allow(path,privilegesFromNames(new String[]{PrivilegeConstants.REP_INDEX_DEFINITION_MANAGEMENT,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  Node n=testSession.getNode(path).getNode(IndexConstants.INDEX_DEFINITIONS_NAME).addNode("myIndex",IndexConstants.INDEX_DEFINITIONS_NODE_TYPE);
  n.setProperty(IndexConstants.TYPE_PROPERTY_NAME,"myType");
  testSession.save();
}
