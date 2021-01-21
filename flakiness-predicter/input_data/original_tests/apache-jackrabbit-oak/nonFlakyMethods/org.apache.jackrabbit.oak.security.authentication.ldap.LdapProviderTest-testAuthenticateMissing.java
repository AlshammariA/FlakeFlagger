@Test public void testAuthenticateMissing() throws Exception {
  SimpleCredentials creds=new SimpleCredentials("foobar" + TEST_USER1_UID,"pass".toCharArray());
  ExternalUser user=idp.authenticate(creds);
  assertNull("Authenticate must return NULL for unknown user",user);
}
