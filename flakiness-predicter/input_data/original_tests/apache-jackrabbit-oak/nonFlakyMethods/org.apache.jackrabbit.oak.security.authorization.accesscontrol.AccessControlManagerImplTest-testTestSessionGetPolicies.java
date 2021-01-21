@Test public void testTestSessionGetPolicies() throws Exception {
  setupPolicy(testPath);
  root.commit();
  Root testRoot=getTestRoot();
  testRoot.refresh();
  JackrabbitAccessControlManager testAcMgr=getTestAccessControlManager();
  PrincipalManager testPrincipalMgr=getPrincipalManager(testRoot);
  List<Principal> principals=ImmutableList.of(testPrincipal,EveryonePrincipal.getInstance());
  for (  Principal principal : principals) {
    if (testPrincipalMgr.hasPrincipal(principal.getName())) {
      AccessControlPolicy[] policies=testAcMgr.getPolicies(principal);
      assertNotNull(policies);
      assertEquals(0,policies.length);
    }
 else {
      assertEquals(0,testAcMgr.getPolicies(principal).length);
    }
  }
}
