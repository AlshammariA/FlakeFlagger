@Test public void testMoveAndAddPropertyAtSource() throws Exception {
  setupMovePermissions();
  testSession.move(nodePath3,siblingDestPath);
  Node n=testSession.getNode(childNPath);
  Property p=n.setProperty("newProp","val");
  try {
    testSession.save();
    fail("Missing ADD_PROPERTY permission.");
  }
 catch (  AccessDeniedException e) {
  }
}
