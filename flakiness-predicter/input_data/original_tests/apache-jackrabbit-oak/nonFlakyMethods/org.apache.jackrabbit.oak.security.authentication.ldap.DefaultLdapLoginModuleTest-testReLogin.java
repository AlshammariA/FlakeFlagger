@Test public void testReLogin() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(new SimpleCredentials(USER_ID,USER_PWD.toCharArray()));
    root.refresh();
    Authorizable user=userManager.getAuthorizable(USER_ID);
    assertNotNull(user);
    assertFalse(root.getTree(user.getPath()).hasProperty(UserConstants.REP_PASSWORD));
    cs.close();
    cs=login(new SimpleCredentials(USER_ID,USER_PWD.toCharArray()));
    root.refresh();
    assertEquals(USER_ID,cs.getAuthInfo().getUserID());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
    options.clear();
  }
}
