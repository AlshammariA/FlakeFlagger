@Test public void testImpersonateDisabledUser() throws Exception {
  user.disable("readonly user is disabled!");
  superuser.save();
  try {
    Session ss=superuser.impersonate(new SimpleCredentials(user.getID(),new char[0]));
    ss.logout();
    fail("A disabled user cannot be impersonated any more.");
  }
 catch (  LoginException e) {
  }
}
