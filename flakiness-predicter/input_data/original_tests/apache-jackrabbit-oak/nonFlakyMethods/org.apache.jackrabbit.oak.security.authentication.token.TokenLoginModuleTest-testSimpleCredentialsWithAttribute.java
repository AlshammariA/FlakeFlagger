@Test public void testSimpleCredentialsWithAttribute() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=new SimpleCredentials("test",new char[0]);
    sc.setAttribute(".token","");
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
