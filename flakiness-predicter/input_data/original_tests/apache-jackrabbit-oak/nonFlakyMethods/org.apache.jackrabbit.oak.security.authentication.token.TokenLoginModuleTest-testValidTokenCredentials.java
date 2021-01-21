@Test public void testValidTokenCredentials() throws Exception {
  Root root=adminSession.getLatestRoot();
  TokenConfiguration tokenConfig=getSecurityProvider().getConfiguration(TokenConfiguration.class);
  TokenProvider tp=tokenConfig.getTokenProvider(root);
  SimpleCredentials sc=(SimpleCredentials)getAdminCredentials();
  TokenInfo info=tp.createToken(sc.getUserID(),Collections.<String,Object>emptyMap());
  ContentSession cs=login(new TokenCredentials(info.getToken()));
  try {
    assertEquals(sc.getUserID(),cs.getAuthInfo().getUserID());
  }
  finally {
    cs.close();
  }
}
