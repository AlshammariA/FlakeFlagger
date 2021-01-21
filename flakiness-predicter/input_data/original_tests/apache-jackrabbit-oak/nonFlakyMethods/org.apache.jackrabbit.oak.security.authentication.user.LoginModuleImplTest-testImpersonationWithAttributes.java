@Test public void testImpersonationWithAttributes() throws Exception {
  ContentSession cs=null;
  try {
    createTestUser();
    SimpleCredentials sc=new SimpleCredentials(USER_ID,USER_PW.toCharArray());
    cs=login(sc);
    AuthInfo authInfo=cs.getAuthInfo();
    cs.close();
    cs=null;
    sc=new SimpleCredentials(USER_ID,new char[0]);
    sc.setAttribute("attr","value");
    ImpersonationCredentials ic=new ImpersonationCredentials(sc,authInfo);
    cs=login(ic);
    authInfo=cs.getAuthInfo();
    assertTrue(Arrays.asList(authInfo.getAttributeNames()).contains("attr"));
    assertEquals("value",authInfo.getAttribute("attr"));
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
