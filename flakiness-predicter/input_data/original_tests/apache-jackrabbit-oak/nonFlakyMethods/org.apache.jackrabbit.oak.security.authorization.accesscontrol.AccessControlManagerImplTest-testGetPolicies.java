@Test public void testGetPolicies() throws Exception {
  AccessControlPolicy policy=getApplicablePolicy(testPath);
  acMgr.setPolicy(testPath,policy);
  AccessControlPolicy[] policies=acMgr.getPolicies(testPath);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof ACL);
  ACL acl=(ACL)policies[0];
  assertTrue(acl.isEmpty());
  assertEquals(testPath,acl.getOakPath());
}
