@Test public void testNullLogin() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(null);
    fail("Null login should fail");
  }
 catch (  LoginException e) {
  }
 finally {
    if (cs != null) {
      cs.close();
    }
  }
}
