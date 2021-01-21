@Test public void testMoveAndModifyProperty() throws Exception {
  setupMovePermissions();
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
