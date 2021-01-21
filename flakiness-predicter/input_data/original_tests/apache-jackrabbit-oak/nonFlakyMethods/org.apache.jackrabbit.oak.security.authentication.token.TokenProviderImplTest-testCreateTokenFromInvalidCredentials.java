@Test public void testCreateTokenFromInvalidCredentials() throws Exception {
  List<Credentials> invalid=new ArrayList<Credentials>();
  invalid.add(new GuestCredentials());
  invalid.add(new TokenCredentials("sometoken"));
  invalid.add(new ImpersonationCredentials(new GuestCredentials(),null));
  invalid.add(new SimpleCredentials("unknownUserId",new char[0]));
  for (  Credentials creds : invalid) {
    assertNull(tokenProvider.createToken(creds));
  }
}
