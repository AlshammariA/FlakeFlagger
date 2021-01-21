@Test public void testLoginWithOldPassword2() throws RepositoryException, NotExecutableException {
  try {
    user.changePassword("changed",testPw);
    superuser.save();
    Session s=getHelper().getRepository().login(new SimpleCredentials(user.getID(),testPw.toCharArray()));
    s.logout();
    fail("superuser pw has changed. login must fail.");
  }
 catch (  LoginException e) {
  }
 finally {
    user.changePassword(testPw);
    superuser.save();
  }
}
