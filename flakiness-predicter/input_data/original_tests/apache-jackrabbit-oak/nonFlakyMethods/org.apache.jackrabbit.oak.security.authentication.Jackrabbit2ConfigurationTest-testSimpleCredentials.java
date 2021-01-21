@Test public void testSimpleCredentials() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(getAdminCredentials());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
