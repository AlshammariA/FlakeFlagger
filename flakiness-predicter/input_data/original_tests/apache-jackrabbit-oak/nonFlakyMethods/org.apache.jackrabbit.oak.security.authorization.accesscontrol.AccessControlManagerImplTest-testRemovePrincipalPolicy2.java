@Test public void testRemovePrincipalPolicy2() throws Exception {
  setupPolicy(testPath);
  root.commit();
  AccessControlPolicy[] policies=acMgr.getPolicies(testPrincipal);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof ACL);
  ACL acl=(ACL)policies[0];
  acMgr.removePolicy(acl.getPath(),acl);
  policies=acMgr.getPolicies(testPath);
  assertEquals(0,policies.length);
  policies=acMgr.getPolicies(testPrincipal);
  assertEquals(0,policies.length);
}
