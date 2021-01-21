@Test public void testTestSessionHasPrivilegesForPrincipals() throws Exception {
  setupPolicy(testPath);
  root.commit();
  AccessControlManagerImpl testAcMgr=getTestAccessControlManager();
  try {
    testAcMgr.getPrivileges(testPath,getPrincipals(adminSession));
    fail("testSession doesn't have sufficient permission to read access control information at testPath");
  }
 catch (  AccessDeniedException e) {
  }
}
