@Test public void testCreateUser2() throws Exception {
  UserManager testUserMgr=getUserManager(testSession);
  Privilege[] privs=privilegesFromNames(new String[]{PrivilegeConstants.REP_USER_MANAGEMENT,PrivilegeConstants.REP_WRITE});
  allow("/",privs);
  testUserMgr.createUser(userId,"pw");
  testSession.save();
}
