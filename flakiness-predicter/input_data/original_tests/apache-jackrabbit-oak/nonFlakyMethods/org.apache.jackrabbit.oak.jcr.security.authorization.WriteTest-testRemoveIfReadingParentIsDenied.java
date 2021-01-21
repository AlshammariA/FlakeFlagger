@Test public void testRemoveIfReadingParentIsDenied() throws Exception {
  deny(path,testUser.getPrincipal(),readPrivileges);
  allow(path,testUser.getPrincipal(),repWritePrivileges);
  allow(childNPath,testUser.getPrincipal(),readWritePrivileges);
  assertFalse(testSession.nodeExists(path));
  assertTrue(testSession.nodeExists(childNPath));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  Node n=testSession.getNode(childNPath);
  n.remove();
  superuser.save();
}
