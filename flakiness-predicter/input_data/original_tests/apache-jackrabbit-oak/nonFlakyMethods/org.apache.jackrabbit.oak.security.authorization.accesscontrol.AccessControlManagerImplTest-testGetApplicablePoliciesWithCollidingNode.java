@Test public void testGetApplicablePoliciesWithCollidingNode() throws Exception {
  NodeUtil testTree=new NodeUtil(root.getTree(testPath));
  testTree.addChild(REP_POLICY,JcrConstants.NT_UNSTRUCTURED);
  AccessControlPolicyIterator itr=acMgr.getApplicablePolicies(testPath);
  assertNotNull(itr);
  assertFalse(itr.hasNext());
}
