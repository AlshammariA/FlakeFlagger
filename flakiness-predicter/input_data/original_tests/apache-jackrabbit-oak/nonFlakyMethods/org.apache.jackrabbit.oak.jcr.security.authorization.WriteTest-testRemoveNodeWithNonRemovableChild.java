/** 
 * @since OAK 1.0 : removal of node doesn't require remove permission onall child nodes (diff to jackrabbit core)
 */
@Test public void testRemoveNodeWithNonRemovableChild() throws Exception {
  Node subtree=superuser.getNode(childNPath).addNode(nodeName3);
  superuser.save();
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(subtree.getPath(),testUser.getPrincipal(),repWritePrivileges);
  assertTrue(testSession.nodeExists(childNPath));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  testSession.getNode(childNPath).remove();
  testSession.save();
}
