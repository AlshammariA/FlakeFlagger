@Test public void testNullLogin() throws Exception {
  ContentSession cs=login(null);
  try {
    AuthInfo authInfo=cs.getAuthInfo();
    String anonymousID=UserUtil.getAnonymousId(getUserConfiguration().getParameters());
    assertEquals(anonymousID,authInfo.getUserID());
  }
  finally {
    cs.close();
  }
}
