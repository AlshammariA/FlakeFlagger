@Test public void testMoveAndModifyProperty3() throws Exception {
  setupMovePermissions();
  allow(childNPath,privilegesFromName(PrivilegeConstants.REP_ALTER_PROPERTIES));
  testSession.move(nodePath3,siblingDestPath);
  Node destNode=testSession.getNode(siblingDestPath);
  destNode.setProperty("movedProp","modified");
}
