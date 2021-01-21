@Test public void testTokenAuthInfo() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=(SimpleCredentials)getAdminCredentials();
    sc.setAttribute(".token","");
    cs=login(sc);
    assertEquals("userid must be correct","admin",cs.getAuthInfo().getUserID());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
