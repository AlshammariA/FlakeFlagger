@Test public void testGetRepoPolicies() throws Exception {
  String path=null;
  AccessControlPolicy[] policies=acMgr.getPolicies(path);
  assertNotNull(policies);
  assertEquals(0,policies.length);
  acMgr.setPolicy(null,acMgr.getApplicablePolicies(path).nextAccessControlPolicy());
  assertFalse(acMgr.getApplicablePolicies(path).hasNext());
  policies=acMgr.getPolicies(path);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof ACL);
  ACL acl=(ACL)policies[0];
  assertTrue(acl.isEmpty());
  assertNull(acl.getPath());
  assertNull(acl.getOakPath());
  assertFalse(acMgr.getApplicablePolicies(path).hasNext());
  acMgr.removePolicy(path,acl);
  assertEquals(0,acMgr.getPolicies(path).length);
  assertTrue(acMgr.getApplicablePolicies(path).hasNext());
}
