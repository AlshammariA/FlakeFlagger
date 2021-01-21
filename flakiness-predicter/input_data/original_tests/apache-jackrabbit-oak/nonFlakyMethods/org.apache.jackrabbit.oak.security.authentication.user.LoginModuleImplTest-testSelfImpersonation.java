@Test public void testSelfImpersonation() throws Exception {
  ContentSession cs=null;
  try {
    createTestUser();
    SimpleCredentials sc=new SimpleCredentials(USER_ID,USER_PW.toCharArray());
    cs=login(sc);
    AuthInfo authInfo=cs.getAuthInfo();
    assertEquals(USER_ID,authInfo.getUserID());
    cs.close();
    sc=new SimpleCredentials(USER_ID,new char[0]);
    ImpersonationCredentials ic=new ImpersonationCredentials(sc,authInfo);
    cs=login(ic);
    authInfo=cs.getAuthInfo();
    assertEquals(USER_ID,authInfo.getUserID());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
