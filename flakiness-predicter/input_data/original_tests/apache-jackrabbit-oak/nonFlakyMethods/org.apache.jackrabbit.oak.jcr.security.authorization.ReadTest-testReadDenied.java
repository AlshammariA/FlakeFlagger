@Test public void testReadDenied() throws Exception {
  deny(path,readPrivileges);
  allow(childNPath,readPrivileges);
  assertFalse(testSession.nodeExists(path));
  assertTrue(testSession.nodeExists(childNPath));
  Node n=testSession.getNode(childNPath);
  n.getDefinition();
}
