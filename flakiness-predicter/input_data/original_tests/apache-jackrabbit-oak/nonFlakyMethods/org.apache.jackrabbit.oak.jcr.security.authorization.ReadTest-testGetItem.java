@Test public void testGetItem() throws Exception {
  deny(path,readPrivileges);
  allow(childNPath,readPrivileges);
  testSession.getItem(childNPath);
}
