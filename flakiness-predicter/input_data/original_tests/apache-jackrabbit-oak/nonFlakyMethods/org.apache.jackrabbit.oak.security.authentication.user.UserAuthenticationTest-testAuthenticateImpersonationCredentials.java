@Test public void testAuthenticateImpersonationCredentials() throws Exception {
  SimpleCredentials sc=new SimpleCredentials(userId,new char[0]);
  assertTrue(authentication.authenticate(new ImpersonationCredentials(sc,adminSession.getAuthInfo())));
}
