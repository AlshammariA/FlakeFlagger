@Test public void testAllowUserDenyGroup() throws Exception {
  allow(path,testUser.getPrincipal(),readPrivileges);
  deny(path,getTestGroup().getPrincipal(),readPrivileges);
  assertTrue(testSession.nodeExists(path));
}
