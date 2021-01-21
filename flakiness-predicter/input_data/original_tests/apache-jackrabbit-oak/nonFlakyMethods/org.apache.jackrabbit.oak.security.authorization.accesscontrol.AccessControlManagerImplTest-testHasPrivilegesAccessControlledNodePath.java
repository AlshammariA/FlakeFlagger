@Test public void testHasPrivilegesAccessControlledNodePath() throws Exception {
  Privilege[] privs=privilegesFromNames(PrivilegeConstants.JCR_ALL);
  for (  String path : getAcContentPaths()) {
    assertTrue(acMgr.hasPrivileges(path,privs));
    assertTrue(acMgr.hasPrivileges(path,getPrincipals(adminSession),privs));
  }
}
