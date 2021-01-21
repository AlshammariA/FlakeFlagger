@Test public void testAllowEveryonePathDenyGroupChildPath() throws Exception {
  allow(path,EveryonePrincipal.getInstance(),readPrivileges);
  deny(childNPath,getTestGroup().getPrincipal(),readPrivileges);
  assertFalse(testSession.nodeExists(childNPath));
}
