@Test public void testChangeUserPropertiesWithoutPermission() throws Exception {
  createUser(userId);
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
