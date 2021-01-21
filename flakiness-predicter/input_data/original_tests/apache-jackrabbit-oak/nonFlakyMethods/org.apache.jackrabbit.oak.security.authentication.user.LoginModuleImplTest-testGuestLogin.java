@Test public void testGuestLogin() throws Exception {
  ContentSession cs=login(new GuestCredentials());
  try {
    AuthInfo authInfo=cs.getAuthInfo();
    String anonymousID=UserUtil.getAnonymousId(getUserConfiguration().getParameters());
    assertEquals(anonymousID,authInfo.getUserID());
  }
  finally {
    cs.close();
  }
}
