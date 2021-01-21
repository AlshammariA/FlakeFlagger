@Test public void testDisableUserWithoutPermission2() throws Exception {
  createUser(userId);
  modify("/",PrivilegeConstants.REP_WRITE,true);
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
