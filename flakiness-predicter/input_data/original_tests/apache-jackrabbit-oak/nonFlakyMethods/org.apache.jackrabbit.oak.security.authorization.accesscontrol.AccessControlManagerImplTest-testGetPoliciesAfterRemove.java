@Test public void testGetPoliciesAfterRemove() throws Exception {
  setupPolicy(testPath);
  AccessControlPolicy[] policies=acMgr.getPolicies(testPath);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  acMgr.removePolicy(testPath,policies[0]);
  policies=acMgr.getPolicies(testPath);
  assertNotNull(policies);
  assertEquals(0,policies.length);
  assertTrue(acMgr.getApplicablePolicies(testPath).hasNext());
}
