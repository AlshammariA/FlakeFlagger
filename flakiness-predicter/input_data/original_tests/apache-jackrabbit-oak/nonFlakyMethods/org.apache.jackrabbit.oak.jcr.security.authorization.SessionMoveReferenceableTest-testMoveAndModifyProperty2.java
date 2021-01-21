@Test public void testMoveAndModifyProperty2() throws Exception {
  setupMovePermissions();
  allow(siblingPath,privilegesFromName(PrivilegeConstants.REP_ALTER_PROPERTIES));
  testSession.move(nodePath3,siblingDestPath);
  Node destNode=testSession.getNode(siblingDestPath);
  destNode.setProperty("movedProp","modified");
  try {
    testSession.save();
    fail("Missing MODIFY_PROPERTY permission.");
  }
 catch (  AccessDeniedException e) {
  }
}
