@Test public void testAccessControlActionForUser() throws Exception {
  UserManager userMgr=getUserManager(root);
  User u=null;
  try {
    String uid="actionTestUser";
    u=userMgr.createUser(uid,uid);
    root.commit();
    assertAcAction(u,PrivilegeConstants.JCR_ALL);
  }
  finally {
    root.refresh();
    if (u != null) {
      u.remove();
    }
    root.commit();
  }
}
