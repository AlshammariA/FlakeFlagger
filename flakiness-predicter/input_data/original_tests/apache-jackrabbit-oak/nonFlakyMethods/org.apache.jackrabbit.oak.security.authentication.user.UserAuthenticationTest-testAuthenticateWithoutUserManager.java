@Test public void testAuthenticateWithoutUserManager() throws Exception {
  UserAuthentication authentication=new UserAuthentication(userId,null);
  assertFalse(authentication.authenticate(new SimpleCredentials(userId,userId.toCharArray())));
}
