@Test public void testGetApplicablePoliciesByPrincipal2() throws Exception {
  setupPolicy(testPath);
  AccessControlPolicy[] applicable=acMgr.getApplicablePolicies(testPrincipal);
  assertNotNull(applicable);
  assertEquals(1,applicable.length);
  assertTrue(applicable[0] instanceof ACL);
  root.commit();
  applicable=acMgr.getApplicablePolicies(testPrincipal);
  assertNotNull(applicable);
  assertEquals(0,applicable.length);
}
