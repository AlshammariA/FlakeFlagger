@Test public void testDisableUserWithoutPermission() throws Exception {
  createUser(userId);
  UserManager testUserMgr=getUserManager(testSession);
  User user=(User)testUserMgr.getAuthorizable(userId);
  try {
    user.disable("disabled!");
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
  }
}
