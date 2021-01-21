@Test public void testDenyUserAllowGroup() throws Exception {
  deny(path,testUser.getPrincipal(),readPrivileges);
  allow(path,getTestGroup().getPrincipal(),readPrivileges);
  assertFalse(testSession.nodeExists(path));
}
