@Test public void testSimpleCredentialsWithAttribute() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=(SimpleCredentials)getAdminCredentials();
    sc.setAttribute(".token","");
    cs=login(sc);
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
