@Test public void testTokenCreationWithImpersonationAttributes() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=(SimpleCredentials)getAdminCredentials();
    sc.setAttribute(".token","");
    sc.setAttribute(".token.mandatory","something");
    sc.setAttribute("attr","val");
    ImpersonationCredentials ic=new ImpersonationCredentials(sc,new AuthInfoImpl(((SimpleCredentials)getAdminCredentials()).getUserID(),Collections.<String,Object>emptyMap(),Collections.<Principal>emptySet()));
    cs=login(ic);
    AuthInfo ai=cs.getAuthInfo();
    Set<String> attrNames=ImmutableSet.copyOf(ai.getAttributeNames());
    assertTrue(attrNames.contains("attr"));
    assertFalse(attrNames.contains(".token"));
    assertFalse(attrNames.contains(".token.mandatory"));
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
