@Test public void testInvalidSimpleCredentialsWithAttribute() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=new SimpleCredentials("test",new char[0]);
    sc.setAttribute(".token","");
    cs=login(sc);
    fail("Invalid simple credentials login should fail");
  }
 catch (  LoginException e) {
  }
 finally {
    if (cs != null) {
      cs.close();
    }
  }
}
