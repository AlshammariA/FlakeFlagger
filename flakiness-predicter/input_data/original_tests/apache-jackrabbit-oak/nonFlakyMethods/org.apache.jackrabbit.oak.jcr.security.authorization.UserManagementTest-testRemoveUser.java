@Test public void testRemoveUser() throws Exception {
  createUser(userId);
  modify("/",PrivilegeConstants.REP_USER_MANAGEMENT,true);
  UserManager testUserMgr=getUserManager(testSession);
  Authorizable a=testUserMgr.getAuthorizable(userId);
  a.remove();
  testSession.save();
}
