@Test public void testAuthenticateWithInvalidCredentials() throws Exception {
  List<Credentials> invalid=new ArrayList<Credentials>();
  invalid.add(new GuestCredentials());
  invalid.add(new SimpleCredentials(userId,new char[0]));
  for (  Credentials creds : invalid) {
    assertFalse(authentication.authenticate(creds));
  }
}
