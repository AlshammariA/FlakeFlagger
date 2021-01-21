@Test public void testGetPrivilegesAccessControlledNodePath() throws Exception {
  Privilege[] expected=privilegesFromNames(PrivilegeConstants.JCR_ALL);
  for (  String path : getAcContentPaths()) {
    assertArrayEquals(expected,acMgr.getPrivileges(path));
    assertArrayEquals(expected,acMgr.getPrivileges(path,getPrincipals(adminSession)));
  }
}
