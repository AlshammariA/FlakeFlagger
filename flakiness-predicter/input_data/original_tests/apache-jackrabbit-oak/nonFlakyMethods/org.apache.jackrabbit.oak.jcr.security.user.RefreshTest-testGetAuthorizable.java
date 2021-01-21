@Test public void testGetAuthorizable() throws RepositoryException {
  User user=null;
  try {
    String uid=createUserId();
    user=userMgr.createUser(uid,uid);
    superuser.save();
    assertNotNull(adminUserManager.getAuthorizable(uid));
  }
  finally {
    if (user != null) {
      user.remove();
      superuser.save();
    }
  }
}
