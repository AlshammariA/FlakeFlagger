@Test public void testRemoveNodeWithInvisibleChild() throws Exception {
  Node invisible=superuser.getNode(childNPath).addNode(nodeName3);
  superuser.save();
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(invisible.getPath(),testUser.getPrincipal(),readPrivileges);
  assertTrue(testSession.nodeExists(childNPath));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  testSession.getNode(childNPath).remove();
  testSession.save();
}
