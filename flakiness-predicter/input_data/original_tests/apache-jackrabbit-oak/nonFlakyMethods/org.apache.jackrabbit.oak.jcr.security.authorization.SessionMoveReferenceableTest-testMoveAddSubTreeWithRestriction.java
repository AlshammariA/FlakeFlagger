@Test public void testMoveAddSubTreeWithRestriction() throws Exception {
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(path,privilegesFromName(PrivilegeConstants.JCR_ADD_CHILD_NODES),createGlobRestriction("*/" + nodeName3));
  testSession.move(childNPath,childNPath2 + "/dest");
  Node dest=testSession.getNode(childNPath2 + "/dest");
  dest.getNode(nodeName3).addNode(nodeName4);
  try {
    testSession.save();
    fail("Adding child node must be denied.");
  }
 catch (  AccessDeniedException e) {
  }
}
