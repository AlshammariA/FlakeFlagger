@Test public void testRemoveNodeWithPolicy() throws Exception {
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  allow(childNPath,testUser.getPrincipal(),readWritePrivileges);
  assertTrue(testSession.nodeExists(childNPath));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  Node n=testSession.getNode(childNPath);
  n.remove();
  testSession.save();
}
