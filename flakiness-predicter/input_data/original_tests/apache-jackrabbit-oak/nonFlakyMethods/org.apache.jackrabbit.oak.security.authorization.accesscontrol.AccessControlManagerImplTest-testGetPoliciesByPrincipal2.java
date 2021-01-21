@Test public void testGetPoliciesByPrincipal2() throws Exception {
  setupPolicy(testPath);
  AccessControlPolicy[] policies=acMgr.getPolicies(testPrincipal);
  assertNotNull(policies);
  assertEquals(0,policies.length);
  root.commit();
  policies=acMgr.getPolicies(testPrincipal);
  assertNotNull(policies);
  assertEquals(1,policies.length);
}
