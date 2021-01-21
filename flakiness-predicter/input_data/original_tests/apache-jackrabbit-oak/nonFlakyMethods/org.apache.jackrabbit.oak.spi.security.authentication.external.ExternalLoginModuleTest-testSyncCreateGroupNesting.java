@Test public void testSyncCreateGroupNesting() throws Exception {
  syncConfig.user().setMembershipNestingDepth(2);
  UserManager userManager=getUserManager(root);
  ContentSession cs=null;
  try {
    cs=login(new SimpleCredentials(userId,new char[0]));
    root.refresh();
    for (    String id : new String[]{"a","b","c","aa","aaa"}) {
      assertNotNull(userManager.getAuthorizable(id));
    }
  }
  finally {
    if (cs != null) {
      cs.close();
    }
    options.clear();
  }
}
