@Test public void testAuthenticateSimpleCredentials() throws Exception {
  assertTrue(authentication.authenticate(new SimpleCredentials(userId,userId.toCharArray())));
}
