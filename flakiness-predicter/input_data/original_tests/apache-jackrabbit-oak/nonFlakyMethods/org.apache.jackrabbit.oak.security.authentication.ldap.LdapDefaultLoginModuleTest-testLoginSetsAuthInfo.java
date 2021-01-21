@Test public void testLoginSetsAuthInfo() throws Exception {
  ContentSession cs=null;
  try {
    SimpleCredentials sc=new SimpleCredentials(USER_ID,USER_PWD.toCharArray());
    sc.setAttribute("attr","val");
    cs=login(sc);
    AuthInfo ai=cs.getAuthInfo();
    assertEquals(USER_ID,ai.getUserID());
    assertEquals("val",ai.getAttribute("attr"));
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
