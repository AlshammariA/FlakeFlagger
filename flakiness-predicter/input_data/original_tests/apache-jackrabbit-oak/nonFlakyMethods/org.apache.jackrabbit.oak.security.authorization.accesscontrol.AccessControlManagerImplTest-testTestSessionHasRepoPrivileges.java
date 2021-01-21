@Test public void testTestSessionHasRepoPrivileges() throws Exception {
  AccessControlManagerImpl testAcMgr=getTestAccessControlManager();
  assertFalse(testAcMgr.hasPrivileges(null,testPrivileges));
  assertFalse(testAcMgr.hasPrivileges(null,getPrincipals(getTestRoot().getContentSession()),testPrivileges));
  try {
    testAcMgr.getPrivileges(null,getPrincipals(adminSession));
    fail("testSession doesn't have sufficient permission to read access control information");
  }
 catch (  AccessDeniedException e) {
  }
}
