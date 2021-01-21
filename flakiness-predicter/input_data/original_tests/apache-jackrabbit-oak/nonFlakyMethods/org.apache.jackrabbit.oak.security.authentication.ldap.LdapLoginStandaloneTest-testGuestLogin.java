@Test public void testGuestLogin() throws Exception {
  try {
    ContentSession sc=login(new GuestCredentials());
    sc.close();
    fail("Guest login must fail.");
  }
 catch (  LoginException e) {
  }
}
