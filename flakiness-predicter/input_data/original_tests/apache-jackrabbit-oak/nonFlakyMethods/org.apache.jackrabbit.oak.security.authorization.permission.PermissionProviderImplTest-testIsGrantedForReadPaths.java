@Test public void testIsGrantedForReadPaths() throws Exception {
  ContentSession testSession=createTestSession();
  try {
    PermissionProvider pp=createPermissionProvider(testSession);
    for (    String path : READ_PATHS) {
      assertTrue(pp.isGranted(path,Permissions.getString(Permissions.READ)));
      assertTrue(pp.isGranted(path,Permissions.getString(Permissions.READ_NODE)));
      assertTrue(pp.isGranted(path + '/' + JcrConstants.JCR_PRIMARYTYPE,Permissions.getString(Permissions.READ_PROPERTY)));
      assertFalse(pp.isGranted(path,Permissions.getString(Permissions.READ_ACCESS_CONTROL)));
    }
    for (    String path : READ_PATHS) {
      Tree tree=root.getTree(path);
      assertTrue(pp.isGranted(tree,null,Permissions.READ));
      assertTrue(pp.isGranted(tree,null,Permissions.READ_NODE));
      assertTrue(pp.isGranted(tree,tree.getProperty(JcrConstants.JCR_PRIMARYTYPE),Permissions.READ_PROPERTY));
      assertFalse(pp.isGranted(tree,null,Permissions.READ_ACCESS_CONTROL));
    }
    RepositoryPermission rp=pp.getRepositoryPermission();
    assertFalse(rp.isGranted(Permissions.READ));
    assertFalse(rp.isGranted(Permissions.READ_NODE));
    assertFalse(rp.isGranted(Permissions.READ_PROPERTY));
    assertFalse(rp.isGranted(Permissions.READ_ACCESS_CONTROL));
  }
  finally {
    testSession.close();
  }
}
