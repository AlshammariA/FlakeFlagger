@Test public void testDenyGroupPathAllowEveryoneChildPath() throws Exception {
  deny(path,getTestGroup().getPrincipal(),readPrivileges);
  allow(path,EveryonePrincipal.getInstance(),readPrivileges);
  assertTrue(testSession.nodeExists(childNPath));
}
