@Test public void testCreateGroupWithExistingUserID() throws RepositoryException, NotExecutableException {
  User u=null;
  try {
    String uid=createUserId();
    u=userMgr.createUser(uid,"pw");
    superuser.save();
    Group gr=null;
    try {
      gr=userMgr.createGroup(uid);
      fail("ID " + uid + " is already in use -> must throw AuthorizableExistsException.");
    }
 catch (    AuthorizableExistsException aee) {
    }
 finally {
      if (gr != null) {
        gr.remove();
        superuser.save();
      }
    }
  }
  finally {
    if (u != null) {
      u.remove();
      superuser.save();
    }
  }
}
