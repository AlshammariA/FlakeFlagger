@Test public void testMoveAndAddPropertyAtSource2() throws Exception {
  setupMovePermissions();
  allow(childNPath,privilegesFromName(PrivilegeConstants.REP_ADD_PROPERTIES));
  testSession.move(nodePath3,siblingDestPath);
  Node n=testSession.getNode(childNPath);
  Property p=n.setProperty("newProp","val");
  testSession.save();
}
