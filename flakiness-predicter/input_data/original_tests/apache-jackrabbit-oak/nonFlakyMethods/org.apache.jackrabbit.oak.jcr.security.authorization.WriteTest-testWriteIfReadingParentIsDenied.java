@Test public void testWriteIfReadingParentIsDenied() throws Exception {
  deny(path,testUser.getPrincipal(),readWritePrivileges);
  allow(childNPath,testUser.getPrincipal(),readWritePrivileges);
  assertFalse(testSession.nodeExists(path));
  assertTrue(testSession.nodeExists(childNPath));
  Node n=testSession.getNode(childNPath);
  n.addNode("someChild");
  n.save();
}
