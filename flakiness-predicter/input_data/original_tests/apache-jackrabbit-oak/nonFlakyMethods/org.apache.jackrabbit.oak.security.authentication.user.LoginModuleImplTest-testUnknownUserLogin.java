@Test public void testUnknownUserLogin() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(new SimpleCredentials("unknown","".toCharArray()));
    fail("Unknown user must not be able to login");
  }
 catch (  LoginException e) {
  }
 finally {
    if (cs != null) {
      cs.close();
    }
  }
}
