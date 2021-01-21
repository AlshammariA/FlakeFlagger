@Test public void testTokenCreationAndLogin() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=(SimpleCredentials)getAdminCredentials();
    sc.setAttribute(".token","");
    cs=login(sc);
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
