@Test public void testCreateTokenWithInvalidExpirationParam() throws Exception {
  SimpleCredentials sc=new SimpleCredentials(userId,new char[0]);
  sc.setAttribute(TokenProvider.PARAM_TOKEN_EXPIRATION,"invalid");
  try {
    tokenProvider.createToken(sc);
    fail();
  }
 catch (  NumberFormatException e) {
  }
}
