@Test public void testLoginWithOldPassword() throws RepositoryException, NotExecutableException {
  try {
    user.changePassword("changed");
    superuser.save();
    Session s=getHelper().getRepository().login(new SimpleCredentials(user.getID(),testPw.toCharArray()));
    s.logout();
    fail("user pw has changed. login must fail.");
  }
 catch (  LoginException e) {
  }
}
