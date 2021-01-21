@Test public void testGetApplicableRepoPolicies() throws Exception {
  AccessControlPolicyIterator itr=acMgr.getApplicablePolicies((String)null);
  assertNotNull(itr);
  assertTrue(itr.hasNext());
  AccessControlPolicy policy=itr.nextAccessControlPolicy();
  assertNotNull(policy);
  assertTrue(policy instanceof ACL);
  ACL acl=(ACL)policy;
  assertTrue(acl.isEmpty());
  assertNull(acl.getPath());
  assertFalse(itr.hasNext());
}
