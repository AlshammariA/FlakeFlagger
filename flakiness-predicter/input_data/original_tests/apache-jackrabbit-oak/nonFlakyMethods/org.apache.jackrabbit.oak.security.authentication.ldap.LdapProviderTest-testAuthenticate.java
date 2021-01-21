@Test public void testAuthenticate() throws Exception {
  SimpleCredentials creds=new SimpleCredentials(TEST_USER1_UID,"pass".toCharArray());
  ExternalUser user=idp.authenticate(creds);
  assertNotNull("User 1 must authenticate",user);
  assertEquals("User Ref",TEST_USER1_DN,user.getExternalId().getId());
}
