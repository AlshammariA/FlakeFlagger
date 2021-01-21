@Test public void testGuestLogin() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(new GuestCredentials());
    fail("GuestCredentials login should fail");
  }
 catch (  LoginException e) {
  }
 finally {
    if (cs != null) {
      cs.close();
    }
  }
}
