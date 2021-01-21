@Test public void testLoginAfterChangePassword2() throws RepositoryException, NotExecutableException {
  try {
    user.changePassword("changed",testPw);
    superuser.save();
    Session s=getHelper().getRepository().login(new SimpleCredentials(user.getID(),"changed".toCharArray()));
    s.logout();
  }
  finally {
    user.changePassword(testPw);
    superuser.save();
  }
}
