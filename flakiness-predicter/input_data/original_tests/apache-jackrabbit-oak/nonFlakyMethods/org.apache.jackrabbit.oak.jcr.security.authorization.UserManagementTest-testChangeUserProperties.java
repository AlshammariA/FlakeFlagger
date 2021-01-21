@Test public void testChangeUserProperties() throws Exception {
  createUser(userId);
  modify("/",PrivilegeConstants.JCR_MODIFY_PROPERTIES,true);
  UserManager testUserMgr=getUserManager(testSession);
  Authorizable a=testUserMgr.getAuthorizable(userId);
  a.setProperty("someProp",testSession.getValueFactory().createValue("value"));
  testSession.save();
  a.setProperty("someProperty",testSession.getValueFactory().createValue("modified"));
  testSession.save();
  a.removeProperty("someProperty");
  testSession.save();
}
