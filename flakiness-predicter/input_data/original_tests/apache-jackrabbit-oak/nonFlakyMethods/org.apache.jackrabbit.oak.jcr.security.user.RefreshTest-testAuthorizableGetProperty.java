@Test public void testAuthorizableGetProperty() throws RepositoryException {
  User user=null;
  try {
    String uid=createUserId();
    user=userMgr.createUser(uid,uid);
    superuser.save();
    Authorizable a=adminUserManager.getAuthorizable(uid);
    user.setProperty("prop",superuser.getValueFactory().createValue("val"));
    superuser.save();
    assertNotNull(a.getProperty("prop"));
  }
  finally {
    if (user != null) {
      user.remove();
      superuser.save();
    }
  }
}
