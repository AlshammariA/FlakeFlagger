@Test public void testGetPoliciesNodeNotAccessControlled() throws Exception {
  AccessControlPolicy[] policies=acMgr.getPolicies(testPath);
  assertNotNull(policies);
  assertEquals(0,policies.length);
}
