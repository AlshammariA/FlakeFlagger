@Test public void testTestSessionGetApplicablePolicies() throws Exception {
  setupPolicy(testPath);
  root.commit();
  Root testRoot=getTestRoot();
  testRoot.refresh();
  JackrabbitAccessControlManager testAcMgr=getTestAccessControlManager();
  List<Principal> principals=ImmutableList.of(testPrincipal,EveryonePrincipal.getInstance());
  for (  Principal principal : principals) {
    AccessControlPolicy[] applicable=testAcMgr.getApplicablePolicies(principal);
    assertNotNull(applicable);
    assertEquals(1,applicable.length);
    assertTrue(applicable[0] instanceof ACL);
  }
}
