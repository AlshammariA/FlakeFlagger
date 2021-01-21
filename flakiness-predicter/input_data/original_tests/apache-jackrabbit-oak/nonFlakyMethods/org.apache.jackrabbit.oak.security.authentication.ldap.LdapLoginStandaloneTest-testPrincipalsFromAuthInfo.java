@Test public void testPrincipalsFromAuthInfo() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=new SimpleCredentials(USER_ID,USER_PWD.toCharArray());
    sc.setAttribute("attr","val");
    cs=login(sc);
    AuthInfo ai=cs.getAuthInfo();
    root.refresh();
    PrincipalProvider pp=getSecurityProvider().getConfiguration(PrincipalConfiguration.class).getPrincipalProvider(root,NamePathMapper.DEFAULT);
    Set<? extends Principal> expected=pp.getPrincipals(USER_ID);
    assertEquals(3,expected.size());
    assertEquals(expected,ai.getPrincipals());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
