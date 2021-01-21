@Test public void testDenyUserPathAllowGroupChildPath() throws Exception {
  deny(path,testUser.getPrincipal(),readPrivileges);
  allow(path,getTestGroup().getPrincipal(),readPrivileges);
  assertFalse(testSession.nodeExists(childNPath));
}
