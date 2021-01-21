@Test public void testGetPrivilegesForReadPaths() throws Exception {
  ContentSession testSession=createTestSession();
  try {
    PermissionProvider pp=createPermissionProvider(testSession);
    for (    String path : READ_PATHS) {
      Tree tree=root.getTree(path);
      assertEquals(Collections.singleton(PrivilegeConstants.JCR_READ),pp.getPrivileges(tree));
    }
    assertEquals(Collections.<String>emptySet(),pp.getPrivileges(null));
  }
  finally {
    testSession.close();
  }
}
