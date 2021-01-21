@Test public void testFindGroupPrincipal() throws Exception {
  Group testGroup=null;
  try {
    UserManager userMgr=getUserManager(root);
    testGroup=userMgr.createGroup("TestGroup");
    root.commit();
    String principalName=testGroup.getPrincipal().getName();
    assertNotNull(principalProvider.getPrincipal(principalName));
    List<String> nameHints=new ArrayList<String>();
    nameHints.add("TestGroup");
    nameHints.add("Test");
    nameHints.add("Group");
    nameHints.add("stGr");
    assertResult(principalProvider,nameHints,principalName,PrincipalManager.SEARCH_TYPE_GROUP,true);
    assertResult(principalProvider,nameHints,principalName,PrincipalManager.SEARCH_TYPE_ALL,true);
    assertResult(principalProvider,nameHints,principalName,PrincipalManager.SEARCH_TYPE_NOT_GROUP,false);
  }
  finally {
    if (testGroup != null) {
      testGroup.remove();
      root.commit();
    }
  }
}
