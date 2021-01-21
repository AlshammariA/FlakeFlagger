/** 
 * @since OAK 1.0 : removal of node doesn't require remove permission onall child items (diff to jackrabbit core)
 */
@Test public void testRemoveNodeWithInvisibleNonRemovableProperty() throws Exception {
  Node subtree=superuser.getNode(childNPath).addNode(nodeName3);
  subtree.setProperty("invisible",14);
  superuser.save();
  String subtreePath=subtree.getPath();
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(subtreePath,testUser.getPrincipal(),privilegesFromNames(new String[]{PrivilegeConstants.REP_READ_PROPERTIES,PrivilegeConstants.REP_REMOVE_PROPERTIES}));
  assertTrue(testSession.nodeExists(childNPath));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  assertTrue(testSession.nodeExists(subtreePath));
  assertFalse(testSession.propertyExists(subtreePath + "/invisible"));
  testSession.getNode(childNPath).remove();
  testSession.save();
}
