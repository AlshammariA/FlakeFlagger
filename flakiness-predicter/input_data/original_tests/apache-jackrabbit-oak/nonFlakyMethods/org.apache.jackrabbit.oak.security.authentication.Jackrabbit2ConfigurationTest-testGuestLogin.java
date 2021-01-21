@Test public void testGuestLogin() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(new GuestCredentials());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
