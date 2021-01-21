@Test public void testMoveAndAddProperty() throws Exception {
  setupMovePermissions();
  testSession.move(nodePath3,siblingDestPath);
  Node destNode=testSession.getNode(siblingDestPath);
  Property p=destNode.setProperty("newProp","val");
  try {
    testSession.save();
    fail("Missing ADD_PROPERTY permission.");
  }
 catch (  AccessDeniedException e) {
  }
}
