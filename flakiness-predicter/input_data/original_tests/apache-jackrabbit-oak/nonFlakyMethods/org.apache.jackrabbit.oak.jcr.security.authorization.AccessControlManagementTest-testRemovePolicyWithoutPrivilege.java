@Test public void testRemovePolicyWithoutPrivilege() throws Exception {
  Privilege[] privileges=privilegesFromName(Privilege.JCR_READ);
  AccessControlPolicy policy=allow(path,privileges);
  assertFalse(testAcMgr.hasPrivileges(path,privilegesFromName(Privilege.JCR_MODIFY_ACCESS_CONTROL)));
  try {
    testAcMgr.removePolicy(path,policy);
    fail("Test user must not be allowed to remove the access control policy.");
  }
 catch (  AccessDeniedException e) {
  }
}
