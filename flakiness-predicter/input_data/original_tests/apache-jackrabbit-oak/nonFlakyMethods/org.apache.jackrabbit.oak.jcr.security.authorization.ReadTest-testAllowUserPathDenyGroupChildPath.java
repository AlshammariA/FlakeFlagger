@Test public void testAllowUserPathDenyGroupChildPath() throws Exception {
  allow(path,testUser.getPrincipal(),readPrivileges);
  deny(path,getTestGroup().getPrincipal(),readPrivileges);
  assertTrue(testSession.nodeExists(childNPath));
}
