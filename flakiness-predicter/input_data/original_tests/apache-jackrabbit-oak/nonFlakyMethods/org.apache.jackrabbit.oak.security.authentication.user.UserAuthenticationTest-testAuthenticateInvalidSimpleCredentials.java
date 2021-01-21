@Test public void testAuthenticateInvalidSimpleCredentials() throws Exception {
  List<Credentials> invalid=new ArrayList<Credentials>();
  invalid.add(new SimpleCredentials(userId,"wrongPw".toCharArray()));
  invalid.add(new SimpleCredentials(userId,"".toCharArray()));
  invalid.add(new SimpleCredentials("unknownUser","pw".toCharArray()));
  for (  Credentials creds : invalid) {
    try {
      authentication.authenticate(creds);
      fail("LoginException expected");
    }
 catch (    LoginException e) {
    }
  }
}
