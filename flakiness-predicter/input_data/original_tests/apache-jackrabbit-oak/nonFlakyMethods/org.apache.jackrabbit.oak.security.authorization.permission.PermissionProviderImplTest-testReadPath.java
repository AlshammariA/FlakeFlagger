@Test public void testReadPath() throws Exception {
  ContentSession testSession=createTestSession();
  try {
    Root r=testSession.getLatestRoot();
    PermissionProvider pp=createPermissionProvider(testSession);
    Tree tree=r.getTree("/");
    assertFalse(tree.exists());
    assertFalse(pp.getTreePermission(tree,TreePermission.EMPTY).canRead());
    for (    String path : READ_PATHS) {
      tree=r.getTree(path);
      assertTrue(tree.exists());
      assertTrue(pp.getTreePermission(tree,TreePermission.EMPTY).canRead());
    }
  }
  finally {
    testSession.close();
  }
}
