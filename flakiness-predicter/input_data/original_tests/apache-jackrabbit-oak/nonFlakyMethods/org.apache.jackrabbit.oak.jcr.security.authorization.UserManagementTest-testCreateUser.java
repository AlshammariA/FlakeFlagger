@Test public void testCreateUser() throws Exception {
  UserManager testUserMgr=getUserManager(testSession);
  modify("/",PrivilegeConstants.REP_USER_MANAGEMENT,true);
  testUserMgr.createUser(userId,"pw");
  testSession.save();
}
