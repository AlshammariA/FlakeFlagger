@Test public void testChangeUserPropertiesWithoutPermission2() throws Exception {
  createUser(userId);
  modify("/",PrivilegeConstants.REP_USER_MANAGEMENT,true);
  UserManager testUserMgr=getUserManager(testSession);
  try {
    Authorizable a=testUserMgr.getAuthorizable(userId);
    a.setProperty("someProp",testSession.getValueFactory().createValue("value"));
    testSession.save();
    fail("Test session doesn't have sufficient permission to alter user properties.");
  }
 catch (  AccessDeniedException e) {
  }
}
