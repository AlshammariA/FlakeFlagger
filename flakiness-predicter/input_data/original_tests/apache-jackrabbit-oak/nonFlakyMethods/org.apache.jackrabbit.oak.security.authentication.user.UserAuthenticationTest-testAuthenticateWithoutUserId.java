@Test public void testAuthenticateWithoutUserId() throws Exception {
  UserAuthentication authentication=new UserAuthentication(null,getUserManager(root));
  assertFalse(authentication.authenticate(new SimpleCredentials(userId,userId.toCharArray())));
}
