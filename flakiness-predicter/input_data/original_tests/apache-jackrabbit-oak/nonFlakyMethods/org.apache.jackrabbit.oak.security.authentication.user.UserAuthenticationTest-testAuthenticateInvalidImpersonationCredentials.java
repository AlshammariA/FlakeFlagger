@Test public void testAuthenticateInvalidImpersonationCredentials() throws Exception {
  List<Credentials> invalid=new ArrayList<Credentials>();
  invalid.add(new ImpersonationCredentials(new GuestCredentials(),adminSession.getAuthInfo()));
  invalid.add(new ImpersonationCredentials(new SimpleCredentials(adminSession.getAuthInfo().getUserID(),new char[0]),new TestAuthInfo()));
  invalid.add(new ImpersonationCredentials(new SimpleCredentials("unknown",new char[0]),adminSession.getAuthInfo()));
  invalid.add(new ImpersonationCredentials(new SimpleCredentials("unknown",new char[0]),new TestAuthInfo()));
  for (  Credentials creds : invalid) {
    try {
      authentication.authenticate(creds);
      fail("LoginException expected");
    }
 catch (    LoginException e) {
    }
  }
}
