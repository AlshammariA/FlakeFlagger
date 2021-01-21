@Test public void testDenyGroupAllowEveryone() throws Exception {
  deny(path,getTestGroup().getPrincipal(),readPrivileges);
  allow(path,EveryonePrincipal.getInstance(),readPrivileges);
  assertTrue(testSession.nodeExists(path));
}
