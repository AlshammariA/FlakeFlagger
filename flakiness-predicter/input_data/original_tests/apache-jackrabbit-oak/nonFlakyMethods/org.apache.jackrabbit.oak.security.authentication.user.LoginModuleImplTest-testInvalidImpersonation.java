@Test public void testInvalidImpersonation() throws Exception {
  ContentSession cs=null;
  try {
    createTestUser();
    SimpleCredentials sc=new SimpleCredentials(USER_ID,USER_PW.toCharArray());
    cs=login(sc);
    AuthInfo authInfo=cs.getAuthInfo();
    assertEquals(USER_ID,authInfo.getUserID());
    cs.close();
    cs=null;
    ConfigurationParameters config=securityProvider.getConfiguration(UserConfiguration.class).getParameters();
    String adminId=UserUtil.getAdminId(config);
    sc=new SimpleCredentials(adminId,new char[0]);
    ImpersonationCredentials ic=new ImpersonationCredentials(sc,authInfo);
    try {
      cs=login(ic);
      fail("User 'test' should not be allowed to impersonate " + adminId);
    }
 catch (    LoginException e) {
    }
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
