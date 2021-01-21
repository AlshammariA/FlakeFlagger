@Test public void testChangePasswordWithoutPermission2() throws Exception {
  createUser(userId);
  modify("/",PrivilegeConstants.REP_WRITE,true);
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
