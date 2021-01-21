@Test public void testRemoveUser2() throws Exception {
  createUser(userId);
  Privilege[] privs=privilegesFromNames(new String[]{PrivilegeConstants.REP_USER_MANAGEMENT,PrivilegeConstants.REP_WRITE});
  allow("/",privs);
  UserManager testUserMgr=getUserManager(testSession);
  Authorizable a=testUserMgr.getAuthorizable(userId);
  a.remove();
  testSession.save();
}
