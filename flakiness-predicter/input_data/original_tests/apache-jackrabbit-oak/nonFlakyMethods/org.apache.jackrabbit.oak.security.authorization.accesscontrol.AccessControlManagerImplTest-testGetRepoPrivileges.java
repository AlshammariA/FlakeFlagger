@Test public void testGetRepoPrivileges() throws Exception {
  assertArrayEquals(privilegesFromNames(PrivilegeConstants.JCR_ALL),acMgr.getPrivileges(null));
}
