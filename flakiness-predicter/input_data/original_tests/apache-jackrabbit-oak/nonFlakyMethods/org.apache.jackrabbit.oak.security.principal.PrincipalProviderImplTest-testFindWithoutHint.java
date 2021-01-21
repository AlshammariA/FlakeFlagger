@Test public void testFindWithoutHint() throws Exception {
  User testUser=null;
  Group testGroup=null;
  try {
    UserManager userMgr=getUserManager(root);
    testUser=userMgr.createUser("TestUser","pw");
    testGroup=userMgr.createGroup("TestGroup");
    root.commit();
    Set<String> resultNames=new HashSet<String>();
    Iterator<? extends Principal> principals=principalProvider.findPrincipals(PrincipalManager.SEARCH_TYPE_ALL);
    while (principals.hasNext()) {
      resultNames.add(principals.next().getName());
    }
    assertTrue(resultNames.contains(EveryonePrincipal.NAME));
    assertTrue(resultNames.contains("TestUser"));
    assertTrue(resultNames.contains("TestGroup"));
  }
  finally {
    if (testUser != null) {
      testUser.remove();
    }
    if (testGroup != null) {
      testGroup.remove();
    }
    root.commit();
  }
}
