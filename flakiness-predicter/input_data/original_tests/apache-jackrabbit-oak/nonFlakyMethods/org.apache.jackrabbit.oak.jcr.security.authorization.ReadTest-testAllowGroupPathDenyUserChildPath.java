@Test public void testAllowGroupPathDenyUserChildPath() throws Exception {
  allow(path,getTestGroup().getPrincipal(),readPrivileges);
  deny(path,testUser.getPrincipal(),readPrivileges);
  assertFalse(testSession.nodeExists(childNPath));
}
