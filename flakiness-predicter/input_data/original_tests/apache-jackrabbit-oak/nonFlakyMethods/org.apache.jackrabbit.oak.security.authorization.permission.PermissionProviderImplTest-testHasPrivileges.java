@Test public void testHasPrivileges() throws Exception {
  ContentSession testSession=createTestSession();
  try {
    PermissionProvider pp=createPermissionProvider(testSession);
    assertTrue(pp.hasPrivileges(null));
    assertTrue(pp.hasPrivileges(null,new String[0]));
    assertFalse(pp.hasPrivileges(null,PrivilegeConstants.JCR_WORKSPACE_MANAGEMENT));
  }
  finally {
    testSession.close();
  }
}
