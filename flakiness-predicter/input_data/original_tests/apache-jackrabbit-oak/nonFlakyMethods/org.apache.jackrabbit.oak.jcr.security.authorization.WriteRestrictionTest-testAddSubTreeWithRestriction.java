@Test public void testAddSubTreeWithRestriction() throws Exception {
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(path,privilegesFromName(PrivilegeConstants.JCR_ADD_CHILD_NODES),createGlobRestriction("*/" + nodeName3));
  Node node4=testSession.getNode(nodePath3).addNode(nodeName4);
  try {
    testSession.save();
    fail("Adding child node must be denied.");
  }
 catch (  AccessDeniedException e) {
  }
}
