@Test public void testRemovePolicy() throws Exception {
  ACL acl=setupPolicy(testPath);
  acMgr.removePolicy(testPath,acl);
  assertEquals(0,acMgr.getPolicies(testPath).length);
  assertTrue(acMgr.getApplicablePolicies(testPath).hasNext());
}
