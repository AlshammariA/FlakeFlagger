@Test public void testRemoveUserWithoutPermission() throws Exception {
  createUser(userId);
  UserManager testUserMgr=getUserManager(testSession);
  try {
    Authorizable a=testUserMgr.getAuthorizable(userId);
    a.remove();
    testSession.save();
    fail("Test session doesn't have sufficient permission to remove a user.");
  }
 catch (  AccessDeniedException e) {
  }
  modify("/",PrivilegeConstants.REP_WRITE,true);
  try {
    Authorizable a=testUserMgr.getAuthorizable(userId);
    a.remove();
    testSession.save();
    fail("Test session doesn't have sufficient permission to remove a user.");
  }
 catch (  AccessDeniedException e) {
  }
}
