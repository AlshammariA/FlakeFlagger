@Test public void testRemoveAdminUser() throws Exception {
  try {
    String adminId=getConfig().getConfigValue(PARAM_ADMIN_ID,DEFAULT_ADMIN_ID);
    UserManager userMgr=getUserManager(root);
    Authorizable admin=userMgr.getAuthorizable(adminId);
    if (admin == null) {
      admin=userMgr.createUser(adminId,adminId);
      root.commit();
    }
    root.getTree(admin.getPath()).remove();
    root.commit();
    fail("Admin user cannot be removed");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
