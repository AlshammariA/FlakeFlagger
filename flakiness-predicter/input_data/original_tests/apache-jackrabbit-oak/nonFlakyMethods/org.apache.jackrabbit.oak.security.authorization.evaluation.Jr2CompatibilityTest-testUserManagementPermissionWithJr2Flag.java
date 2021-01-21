@Test public void testUserManagementPermissionWithJr2Flag() throws Exception {
  Root testRoot=getTestRoot();
  testRoot.refresh();
  UserManager testUserMgr=getUserConfiguration().getUserManager(testRoot,NamePathMapper.DEFAULT);
  try {
    User u=testUserMgr.createUser("a","b");
    testRoot.commit();
    u.changePassword("c");
    testRoot.commit();
    u.remove();
    testRoot.commit();
  }
  finally {
    root.refresh();
    Authorizable user=getUserManager(root).getAuthorizable("a");
    if (user != null) {
      user.remove();
      root.commit();
    }
  }
}
