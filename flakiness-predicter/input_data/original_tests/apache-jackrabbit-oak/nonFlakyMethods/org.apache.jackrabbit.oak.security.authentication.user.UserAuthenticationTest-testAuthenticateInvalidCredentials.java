@Test public void testAuthenticateInvalidCredentials() throws Exception {
  List<Credentials> invalid=new ArrayList<Credentials>();
  invalid.add(new TokenCredentials("token"));
  invalid.add(new Credentials(){
  }
);
  for (  Credentials creds : invalid) {
    assertFalse(authentication.authenticate(creds));
  }
}
