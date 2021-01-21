@Test public void testMoveAndRemovePropertyAtSource() throws Exception {
  setupMovePermissions();
  testSession.move(nodePath3,siblingDestPath);
  Node n=testSession.getNode(childNPath);
  assertTrue(n.hasProperty(propertyName1));
  n.getProperty(propertyName1).remove();
  try {
    testSession.save();
    fail("Missing REMOVE_PROPERTY permission.");
  }
 catch (  AccessDeniedException e) {
  }
}
