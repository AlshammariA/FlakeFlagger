@Test public void testLoginWithGetCredentials() throws RepositoryException, NotExecutableException {
  try {
    Credentials creds=user.getCredentials();
    Session s=getHelper().getRepository().login(creds);
    s.logout();
    fail("Login using credentials exposed on user must fail.");
  }
 catch (  UnsupportedRepositoryOperationException e) {
    throw new NotExecutableException(e.getMessage());
  }
catch (  LoginException e) {
  }
}
