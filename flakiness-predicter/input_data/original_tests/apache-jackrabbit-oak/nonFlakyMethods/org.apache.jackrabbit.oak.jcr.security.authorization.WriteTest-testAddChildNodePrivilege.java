/** 
 * the ADD_CHILD_NODES privileges assigned on a node to a specific principal grants the corresponding user the permission to add nodes below the target node but not 'at' the target node.
 * @throws Exception If an error occurs.
 */
@Test public void testAddChildNodePrivilege() throws Exception {
  Privilege[] privileges=privilegesFromName(Privilege.JCR_ADD_CHILD_NODES);
  allow(path,privileges);
  assertFalse(testSession.hasPermission(path,Session.ACTION_ADD_NODE));
  assertTrue(testSession.hasPermission(path + "/anychild",Session.ACTION_ADD_NODE));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_ADD_NODE));
}
