/** 
 * @since OAK 1.0 : removal of node doesn't require remove permission onall child nodes (diff to jackrabbit core)
 */
@Test public void testRemoveNodeWithInvisibleNonRemovableChild() throws Exception {
  Node invisible=superuser.getNode(childNPath).addNode(nodeName3);
  superuser.save();
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(invisible.getPath(),testUser.getPrincipal(),readWritePrivileges);
  assertTrue(testSession.nodeExists(childNPath));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  testSession.getNode(childNPath).remove();
  testSession.save();
}
