@Test public void testAdministatorConfig() throws Exception {
  adminstrators.addMember(getTestUser());
  root.commit();
  ContentSession testSession=createTestSession();
  try {
    Root r=testSession.getLatestRoot();
    Root immutableRoot=new ImmutableRoot(r);
    PermissionProvider pp=createPermissionProvider(testSession);
    assertTrue(r.getTree("/").exists());
    TreePermission tp=pp.getTreePermission(immutableRoot.getTree("/"),TreePermission.EMPTY);
    assertSame(TreePermission.ALL,tp);
    for (    String path : READ_PATHS) {
      Tree tree=r.getTree(path);
      assertTrue(tree.exists());
      assertSame(TreePermission.ALL,pp.getTreePermission(tree,TreePermission.EMPTY));
    }
  }
  finally {
    testSession.close();
  }
}
