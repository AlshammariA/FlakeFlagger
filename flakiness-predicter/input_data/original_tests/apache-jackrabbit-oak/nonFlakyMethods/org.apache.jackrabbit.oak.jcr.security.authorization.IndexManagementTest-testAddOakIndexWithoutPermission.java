public void testAddOakIndexWithoutPermission() throws Exception {
  allow(path,privilegesFromName(PrivilegeConstants.REP_WRITE));
  Node n=testSession.getNode(path);
  try {
    n.addNode(IndexConstants.INDEX_DEFINITIONS_NAME);
    testSession.save();
    fail("AccessDeniedException expected. Test session is not allowed to add oak:index node.");
  }
 catch (  AccessDeniedException e) {
  }
}
