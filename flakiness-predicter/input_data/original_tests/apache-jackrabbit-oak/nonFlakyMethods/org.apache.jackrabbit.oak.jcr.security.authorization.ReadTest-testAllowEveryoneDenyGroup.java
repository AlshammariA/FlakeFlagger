@Test public void testAllowEveryoneDenyGroup() throws Exception {
  allow(path,EveryonePrincipal.getInstance(),readPrivileges);
  deny(path,getTestGroup().getPrincipal(),readPrivileges);
  assertFalse(testSession.nodeExists(path));
}
