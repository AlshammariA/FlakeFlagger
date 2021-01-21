@Test public void testGetApplicablePolicies() throws Exception {
  AccessControlPolicyIterator itr=acMgr.getApplicablePolicies(testPath);
  assertNotNull(itr);
  assertTrue(itr.hasNext());
  AccessControlPolicy policy=itr.nextAccessControlPolicy();
  assertNotNull(policy);
  assertTrue(policy instanceof ACL);
  ACL acl=(ACL)policy;
  assertTrue(acl.isEmpty());
  assertEquals(testPath,acl.getPath());
  assertFalse(itr.hasNext());
}
