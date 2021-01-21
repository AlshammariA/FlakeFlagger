@Test public void testAllowGroupDenyUser() throws Exception {
  allow(path,getTestGroup().getPrincipal(),readPrivileges);
  deny(path,testUser.getPrincipal(),readPrivileges);
  assertFalse(testSession.nodeExists(path));
}
