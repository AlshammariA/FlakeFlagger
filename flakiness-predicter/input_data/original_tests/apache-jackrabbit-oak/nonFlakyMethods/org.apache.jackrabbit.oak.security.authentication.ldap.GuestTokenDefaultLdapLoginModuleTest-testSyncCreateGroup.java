@Test public void testSyncCreateGroup() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(new SimpleCredentials(USER_ID,USER_PWD.toCharArray()));
    root.refresh();
    assertNotNull(userManager.getAuthorizable(USER_ID));
    assertNotNull(userManager.getAuthorizable(GROUP_NAME));
  }
  finally {
    if (cs != null) {
      cs.close();
    }
    options.clear();
  }
}
