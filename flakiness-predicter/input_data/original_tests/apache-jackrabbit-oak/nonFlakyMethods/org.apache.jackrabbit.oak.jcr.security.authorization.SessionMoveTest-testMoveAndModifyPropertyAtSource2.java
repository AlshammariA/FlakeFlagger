@Test public void testMoveAndModifyPropertyAtSource2() throws Exception {
  setupMovePermissions();
  allow(childNPath,privilegesFromName(PrivilegeConstants.REP_ALTER_PROPERTIES));
  testSession.move(nodePath3,siblingDestPath);
  Node n=testSession.getNode(childNPath);
  assertTrue(n.hasProperty(propertyName1));
  n.setProperty(propertyName1,"modified");
  testSession.save();
}
