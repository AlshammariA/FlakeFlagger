public void testAddOakIndexDefinition() throws Exception {
  allow(path,privilegesFromName(PrivilegeConstants.REP_INDEX_DEFINITION_MANAGEMENT));
  Node n=testSession.getNode(path);
  n.addNode(IndexConstants.INDEX_DEFINITIONS_NAME);
  testSession.save();
}
