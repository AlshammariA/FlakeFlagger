@Test public void testMoveAndRemoveProperty() throws Exception {
  setupMovePermissions();
  testSession.move(nodePath3,siblingDestPath);
  Node destNode=testSession.getNode(siblingDestPath);
  destNode.getProperty("movedProp").remove();
  try {
    testSession.save();
    fail("Missing REMOVE_PROPERTY permission.");
  }
 catch (  AccessDeniedException e) {
  }
}
