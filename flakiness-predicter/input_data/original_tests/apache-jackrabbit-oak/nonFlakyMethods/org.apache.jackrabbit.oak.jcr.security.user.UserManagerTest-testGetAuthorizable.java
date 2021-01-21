@Test public void testGetAuthorizable() throws RepositoryException, NotExecutableException {
  String uid=createUserId();
  User user=null;
  try {
    user=userMgr.createUser(uid,uid);
    superuser.save();
    assertEquals(uid,user.getID());
    assertNotNull(userMgr.getAuthorizable(uid));
    assertEquals(user,userMgr.getAuthorizable(uid));
    assertNotNull(getNode(user,superuser));
  }
  finally {
    if (user != null) {
      user.remove();
    }
  }
}
