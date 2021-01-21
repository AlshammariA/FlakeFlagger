@Test public void testLoginDisabledUser() throws Exception {
  user.disable("readonly user is disabled!");
  superuser.save();
  try {
    Session ss=getHelper().getRepository().login(new SimpleCredentials(user.getID(),"pw".toCharArray()));
    ss.logout();
    fail("A disabled user must not be allowed to login any more");
  }
 catch (  LoginException e) {
  }
}
