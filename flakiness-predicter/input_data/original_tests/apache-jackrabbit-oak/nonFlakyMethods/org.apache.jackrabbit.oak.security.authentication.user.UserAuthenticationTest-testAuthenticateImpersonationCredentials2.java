@Test public void testAuthenticateImpersonationCredentials2() throws Exception {
  SimpleCredentials sc=new SimpleCredentials(userId,new char[0]);
  assertTrue(authentication.authenticate(new ImpersonationCredentials(sc,new TestAuthInfo())));
}
