@Test public void testRemoveNodeWithInvisibleProperty() throws Exception {
  Node subtree=superuser.getNode(childNPath).addNode(nodeName3);
  subtree.setProperty("invisible",14);
  superuser.save();
  String subtreePath=subtree.getPath();
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(subtreePath,testUser.getPrincipal(),privilegesFromName(PrivilegeConstants.REP_READ_PROPERTIES));
  assertTrue(testSession.nodeExists(childNPath));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  assertTrue(testSession.nodeExists(subtreePath));
  assertFalse(testSession.propertyExists(subtreePath + "/invisible"));
  testSession.getNode(childNPath).remove();
  testSession.save();
}
