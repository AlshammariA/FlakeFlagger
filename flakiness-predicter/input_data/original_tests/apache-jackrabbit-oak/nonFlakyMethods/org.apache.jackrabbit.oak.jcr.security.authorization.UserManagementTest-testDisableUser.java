@Test public void testDisableUser() throws Exception {
  createUser(userId);
  modify("/",PrivilegeConstants.REP_USER_MANAGEMENT,true);
  UserManager testUserMgr=getUserManager(testSession);
  User user=(User)testUserMgr.getAuthorizable(userId);
  user.disable("disabled!");
  testSession.save();
}
