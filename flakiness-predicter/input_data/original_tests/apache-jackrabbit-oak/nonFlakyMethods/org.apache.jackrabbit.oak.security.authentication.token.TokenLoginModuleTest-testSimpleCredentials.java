@Test public void testSimpleCredentials() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=new SimpleCredentials("admin","admin".toCharArray());
    cs=login(sc);
    fail("Unsupported credentials login should fail");
  }
 catch (  LoginException e) {
  }
 finally {
    if (cs != null) {
      cs.close();
    }
  }
}
