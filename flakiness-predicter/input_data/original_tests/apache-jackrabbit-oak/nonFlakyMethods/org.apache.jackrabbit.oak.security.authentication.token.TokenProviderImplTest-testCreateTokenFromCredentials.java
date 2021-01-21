@Test public void testCreateTokenFromCredentials() throws Exception {
  SimpleCredentials sc=new SimpleCredentials(userId,new char[0]);
  List<Credentials> valid=new ArrayList<Credentials>();
  valid.add(sc);
  valid.add(new ImpersonationCredentials(sc,null));
  for (  Credentials creds : valid) {
    TokenInfo info=tokenProvider.createToken(creds);
    assertTokenInfo(info,userId);
  }
}
