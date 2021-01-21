@Test public void testGetApplicablePoliciesForAccessControlled() throws Exception {
  AccessControlPolicy policy=getApplicablePolicy(testPath);
  acMgr.setPolicy(testPath,policy);
  AccessControlPolicyIterator itr=acMgr.getApplicablePolicies(testPath);
  assertNotNull(itr);
  assertFalse(itr.hasNext());
}
