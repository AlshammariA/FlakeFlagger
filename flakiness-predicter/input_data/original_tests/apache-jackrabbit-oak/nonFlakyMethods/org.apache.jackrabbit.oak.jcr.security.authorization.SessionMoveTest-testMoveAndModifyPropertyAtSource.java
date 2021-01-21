@Test public void testMoveAndModifyPropertyAtSource() throws Exception {
  setupMovePermissions();
  testSession.move(nodePath3,siblingDestPath);
  Node n=testSession.getNode(childNPath);
  assertTrue(n.hasProperty(propertyName1));
  n.setProperty(propertyName1,"modified");
  try {
    testSession.save();
    fail("Missing MODIFY_PROPERTY permission.");
  }
 catch (  AccessDeniedException e) {
  }
  allow(childNPath,privilegesFromName(PrivilegeConstants.REP_ALTER_PROPERTIES));
  testSession.save();
}
