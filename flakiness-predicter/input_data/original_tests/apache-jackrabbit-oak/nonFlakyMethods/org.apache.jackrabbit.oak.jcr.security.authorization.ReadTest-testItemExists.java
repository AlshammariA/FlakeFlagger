@Test public void testItemExists() throws Exception {
  deny(path,readPrivileges);
  allow(childNPath,readPrivileges);
  assertFalse(testSession.itemExists(path));
  assertTrue(testSession.itemExists(childNPath));
}
