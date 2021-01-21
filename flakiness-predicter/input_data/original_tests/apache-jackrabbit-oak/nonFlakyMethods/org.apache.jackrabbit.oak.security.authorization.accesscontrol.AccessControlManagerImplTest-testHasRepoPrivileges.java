@Test public void testHasRepoPrivileges() throws Exception {
  assertTrue(acMgr.hasPrivileges(null,privilegesFromNames(PrivilegeConstants.JCR_ALL)));
  assertTrue(acMgr.hasPrivileges(null,getPrincipals(adminSession),privilegesFromNames(PrivilegeConstants.JCR_ALL)));
}
