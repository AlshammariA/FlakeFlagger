@Test public void testSyncCreateUser() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(new SimpleCredentials(USER_ID,USER_PWD.toCharArray()));
    root.refresh();
    Authorizable user=userManager.getAuthorizable(USER_ID);
    assertNotNull(user);
    assertTrue(user.hasProperty(USER_PROP));
    Tree userTree=cs.getLatestRoot().getTree(user.getPath());
    assertFalse(userTree.hasProperty(UserConstants.REP_PASSWORD));
    assertNull(userManager.getAuthorizable(GROUP_DN));
  }
  finally {
    if (cs != null) {
      cs.close();
    }
    options.clear();
  }
}
