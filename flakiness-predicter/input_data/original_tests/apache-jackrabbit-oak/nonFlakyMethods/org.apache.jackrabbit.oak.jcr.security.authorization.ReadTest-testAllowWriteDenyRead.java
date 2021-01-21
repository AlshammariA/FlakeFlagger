@Test public void testAllowWriteDenyRead() throws Exception {
  allow(path,repWritePrivileges);
  deny(path,readPrivileges);
  assertFalse(testSession.nodeExists(path));
}
