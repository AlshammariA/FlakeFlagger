@Test public void testInvalidTokenCredentials() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(new TokenCredentials("invalid"));
    fail("Invalid token credentials login should fail");
  }
 catch (  LoginException e) {
  }
 finally {
    if (cs != null) {
      cs.close();
    }
  }
}
