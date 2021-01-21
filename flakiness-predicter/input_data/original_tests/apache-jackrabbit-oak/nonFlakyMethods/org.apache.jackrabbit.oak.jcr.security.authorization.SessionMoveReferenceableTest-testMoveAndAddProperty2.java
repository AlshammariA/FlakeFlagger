@Test public void testMoveAndAddProperty2() throws Exception {
  setupMovePermissions();
  allow(childNPath,privilegesFromName(PrivilegeConstants.REP_ADD_PROPERTIES));
  testSession.move(nodePath3,siblingDestPath);
  Node destNode=testSession.getNode(siblingDestPath);
  Property p=destNode.setProperty("newProp","val");
  testSession.save();
}
