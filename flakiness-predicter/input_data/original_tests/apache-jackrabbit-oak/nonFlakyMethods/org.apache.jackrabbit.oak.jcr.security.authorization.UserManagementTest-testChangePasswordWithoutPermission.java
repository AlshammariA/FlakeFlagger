@Test public void testChangePasswordWithoutPermission() throws Exception {
  createUser(userId);
  UserManager testUserMgr=getUserManager(testSession);
  User user=(User)testUserMgr.getAuthorizable(userId);
  try {
    user.changePassword("pw2");
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
  }
}
