@Test public void testAuthenticateFail() throws Exception {
  SimpleCredentials creds=new SimpleCredentials(TEST_USER1_UID,"foobar".toCharArray());
  try {
    idp.authenticate(creds);
    fail("Authenticate must fail with LoginException for wrong password");
  }
 catch (  LoginException e) {
  }
}
