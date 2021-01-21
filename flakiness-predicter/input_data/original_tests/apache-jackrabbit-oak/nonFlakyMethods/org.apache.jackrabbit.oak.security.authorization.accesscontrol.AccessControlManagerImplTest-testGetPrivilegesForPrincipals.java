@Test public void testGetPrivilegesForPrincipals() throws Exception {
  Set<Principal> adminPrincipals=getPrincipals(adminSession);
  Privilege[] expected=privilegesFromNames(PrivilegeConstants.JCR_ALL);
  assertArrayEquals(expected,acMgr.getPrivileges("/",adminPrincipals));
  assertArrayEquals(expected,acMgr.getPrivileges(null,adminPrincipals));
  assertArrayEquals(expected,acMgr.getPrivileges(testPath,adminPrincipals));
  setupPolicy(testPath);
  root.commit();
  Set<Principal> testPrincipals=Collections.singleton(testPrincipal);
  assertArrayEquals(new Privilege[0],acMgr.getPrivileges(null,testPrincipals));
  assertArrayEquals(new Privilege[0],acMgr.getPrivileges("/",testPrincipals));
  assertEquals(ImmutableSet.copyOf(testPrivileges),ImmutableSet.copyOf(acMgr.getPrivileges(testPath,testPrincipals)));
}
