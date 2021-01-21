@Test public void testGetPoliciesAfterSet() throws Exception {
  setupPolicy(testPath);
  AccessControlPolicy[] policies=acMgr.getPolicies(testPath);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof ACL);
  ACL acl=(ACL)policies[0];
  assertFalse(acl.isEmpty());
}
