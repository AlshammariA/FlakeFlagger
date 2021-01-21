@Test public void testMoveAndRemovePropertyAtSource2() throws Exception {
  setupMovePermissions();
  allow(childNPath,privilegesFromName(PrivilegeConstants.REP_REMOVE_PROPERTIES));
  testSession.move(nodePath3,siblingDestPath);
  Node n=testSession.getNode(childNPath);
  assertTrue(n.hasProperty(propertyName1));
  n.getProperty(propertyName1).remove();
  testSession.save();
}
