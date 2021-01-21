@Test public void testTestSessionGetPrivileges() throws Exception {
  setupPolicy(testPath);
  root.commit();
  AccessControlManagerImpl testAcMgr=getTestAccessControlManager();
  Set<Principal> testPrincipals=getPrincipals(getTestRoot().getContentSession());
  assertArrayEquals(new Privilege[0],testAcMgr.getPrivileges(null));
  assertArrayEquals(new Privilege[0],testAcMgr.getPrivileges(null,testPrincipals));
  Privilege[] privs=testAcMgr.getPrivileges(testPath);
  assertEquals(ImmutableSet.copyOf(testPrivileges),ImmutableSet.copyOf(privs));
  privs=testAcMgr.getPrivileges(testPath,testPrincipals);
  assertEquals(ImmutableSet.copyOf(testPrivileges),ImmutableSet.copyOf(privs));
  try {
    testAcMgr.getPrivileges(testPath,getPrincipals(adminSession));
    fail("testSession doesn't have sufficient permission to read access control information at testPath");
  }
 catch (  AccessDeniedException e) {
  }
}
