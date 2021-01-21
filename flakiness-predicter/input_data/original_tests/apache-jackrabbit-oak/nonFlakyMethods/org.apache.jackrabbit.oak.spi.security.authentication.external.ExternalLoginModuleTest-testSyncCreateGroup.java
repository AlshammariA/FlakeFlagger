@Test public void testSyncCreateGroup() throws Exception {
  UserManager userManager=getUserManager(root);
  ContentSession cs=null;
  try {
    cs=login(new SimpleCredentials(userId,new char[0]));
    root.refresh();
    for (    String id : new String[]{"a","b","c"}) {
      assertNotNull(userManager.getAuthorizable(id));
    }
    for (    String id : new String[]{"aa","aaa"}) {
      assertNull(userManager.getAuthorizable(id));
    }
  }
  finally {
    if (cs != null) {
      cs.close();
    }
    options.clear();
  }
}
