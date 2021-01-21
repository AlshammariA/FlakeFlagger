@Test public void testHasPrivilegesForReadPaths() throws Exception {
  ContentSession testSession=createTestSession();
  try {
    PermissionProvider pp=createPermissionProvider(testSession);
    for (    String path : READ_PATHS) {
      Tree tree=root.getTree(path);
      assertTrue(pp.hasPrivileges(tree,PrivilegeConstants.JCR_READ));
      assertTrue(pp.hasPrivileges(tree,PrivilegeConstants.REP_READ_NODES));
      assertTrue(pp.hasPrivileges(tree,PrivilegeConstants.REP_READ_PROPERTIES));
      assertFalse(pp.hasPrivileges(tree,PrivilegeConstants.JCR_READ_ACCESS_CONTROL));
    }
    assertFalse(pp.hasPrivileges(null,PrivilegeConstants.JCR_READ));
  }
  finally {
    testSession.close();
  }
}
