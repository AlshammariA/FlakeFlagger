@Test public void testCreateGroup2() throws Exception {
  UserManager testUserMgr=getUserManager(testSession);
  Privilege[] privs=privilegesFromNames(new String[]{PrivilegeConstants.REP_USER_MANAGEMENT,PrivilegeConstants.REP_WRITE});
  allow("/",privs);
  Group gr=testUserMgr.createGroup(groupId);
  testSession.save();
}
