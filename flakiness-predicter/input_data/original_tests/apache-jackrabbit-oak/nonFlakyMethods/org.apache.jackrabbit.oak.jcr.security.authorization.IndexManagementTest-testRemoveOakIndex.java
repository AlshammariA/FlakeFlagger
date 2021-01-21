public void testRemoveOakIndex() throws Exception {
  Node indexDef=superuser.getNode(path).addNode(IndexConstants.INDEX_DEFINITIONS_NAME).addNode("myIndex",IndexConstants.INDEX_DEFINITIONS_NODE_TYPE);
  indexDef.setProperty(IndexConstants.TYPE_PROPERTY_NAME,"myType");
  superuser.save();
  allow(path,privilegesFromName(PrivilegeConstants.REP_INDEX_DEFINITION_MANAGEMENT));
  Node n=testSession.getNode(path).getNode(IndexConstants.INDEX_DEFINITIONS_NAME);
  n.remove();
  testSession.save();
}
