@Test public void testUserLogin() throws Exception {
  ContentSession cs=null;
  try {
    createTestUser();
    cs=login(new SimpleCredentials(USER_ID,USER_PW.toCharArray()));
    AuthInfo authInfo=cs.getAuthInfo();
    assertEquals(USER_ID,authInfo.getUserID());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
