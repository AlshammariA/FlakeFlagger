@Test public void testRemoveRepoPolicy() throws Exception {
  ACL acl=setupPolicy(null);
  acMgr.removePolicy(null,acl);
  assertEquals(0,acMgr.getPolicies((String)null).length);
  assertTrue(acMgr.getApplicablePolicies((String)null).hasNext());
}
