@Test public void testCreateGroup() throws Exception {
  UserManager testUserMgr=getUserManager(testSession);
  modify("/",PrivilegeConstants.REP_USER_MANAGEMENT,true);
  Group gr=testUserMgr.createGroup(groupId);
  testSession.save();
}
