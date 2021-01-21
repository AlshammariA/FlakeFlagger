@Test public void testCreateUserWithoutPermission() throws Exception {
  UserManager testUserMgr=getUserManager(testSession);
  try {
    testUserMgr.createUser(userId,"pw");
    testSession.save();
    fail("Test session doesn't have sufficient permission -> creating user should fail.");
  }
 catch (  AccessDeniedException e) {
  }
  modify("/",PrivilegeConstants.REP_WRITE,true);
  try {
    testUserMgr.createUser(userId,"pw");
    testSession.save();
    fail("Test session doesn't have sufficient permission -> creating user should fail.");
  }
 catch (  AccessDeniedException e) {
  }
}
