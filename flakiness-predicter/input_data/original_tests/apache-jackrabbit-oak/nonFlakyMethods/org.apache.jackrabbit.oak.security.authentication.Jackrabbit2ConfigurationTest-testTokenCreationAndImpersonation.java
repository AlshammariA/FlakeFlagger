@Test public void testTokenCreationAndImpersonation() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=(SimpleCredentials)getAdminCredentials();
    sc.setAttribute(".token","");
    ImpersonationCredentials ic=new ImpersonationCredentials(sc,new AuthInfoImpl(((SimpleCredentials)getAdminCredentials()).getUserID(),Collections.<String,Object>emptyMap(),Collections.<Principal>emptySet()));
    cs=login(ic);
    Object token=sc.getAttribute(".token").toString();
    assertNotNull(token);
    TokenCredentials tc=new TokenCredentials(token.toString());
    cs.close();
    cs=login(tc);
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
