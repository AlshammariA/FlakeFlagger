@Test public void testMoveRemoveSubTreeWithRestriction2() throws Exception {
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(path,privilegesFromName(PrivilegeConstants.JCR_REMOVE_CHILD_NODES),createGlobRestriction("*/" + Text.getName(childNPath)));
  assertTrue(testSession.nodeExists(childNPath));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  assertTrue(testSession.hasPermission(childNPath2,Session.ACTION_ADD_NODE));
  testSession.move(childNPath,childNPath2 + "/dest");
  Node dest=testSession.getNode(childNPath2 + "/dest");
  dest.getNode(nodeName3).remove();
  try {
    testSession.save();
    fail("Removing child node must be denied.");
  }
 catch (  AccessDeniedException e) {
  }
}
