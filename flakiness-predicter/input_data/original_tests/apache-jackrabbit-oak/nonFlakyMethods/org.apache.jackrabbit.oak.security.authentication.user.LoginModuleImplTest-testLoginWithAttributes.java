@Test public void testLoginWithAttributes() throws Exception {
  ContentSession cs=null;
  try {
    createTestUser();
    SimpleCredentials sc=new SimpleCredentials(USER_ID,USER_PW.toCharArray());
    sc.setAttribute("attr","value");
    cs=login(sc);
    AuthInfo authInfo=cs.getAuthInfo();
    assertTrue(Arrays.asList(authInfo.getAttributeNames()).contains("attr"));
    assertEquals("value",authInfo.getAttribute("attr"));
    cs.close();
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
