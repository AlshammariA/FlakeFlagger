@Test public void testFindUserPrincipal() throws Exception {
  User testUser=null;
  try {
    UserManager userMgr=getUserManager(root);
    testUser=userMgr.createUser("TestUser","pw");
    root.commit();
    String principalName=testUser.getPrincipal().getName();
    assertNotNull(principalProvider.getPrincipal(principalName));
    List<String> nameHints=new ArrayList<String>();
    nameHints.add("TestUser");
    nameHints.add("Test");
    nameHints.add("User");
    nameHints.add("stUs");
    assertResult(principalProvider,nameHints,principalName,PrincipalManager.SEARCH_TYPE_NOT_GROUP,true);
    assertResult(principalProvider,nameHints,principalName,PrincipalManager.SEARCH_TYPE_ALL,true);
    assertResult(principalProvider,nameHints,principalName,PrincipalManager.SEARCH_TYPE_GROUP,false);
  }
  finally {
    if (testUser != null) {
      testUser.remove();
      root.commit();
    }
  }
}
