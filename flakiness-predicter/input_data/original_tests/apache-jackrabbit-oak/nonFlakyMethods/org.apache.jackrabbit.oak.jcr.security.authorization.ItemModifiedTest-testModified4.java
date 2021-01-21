@Test public void testModified4() throws Exception {
  deny(path,privilegesFromName(PrivilegeConstants.REP_READ_PROPERTIES));
  Node n=testSession.getNode(childNPath);
  assertFalse(n.isModified());
}
