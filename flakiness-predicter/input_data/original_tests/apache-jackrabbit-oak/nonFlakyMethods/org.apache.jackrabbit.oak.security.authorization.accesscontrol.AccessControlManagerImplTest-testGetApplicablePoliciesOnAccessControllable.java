@Test public void testGetApplicablePoliciesOnAccessControllable() throws Exception {
  NodeUtil node=new NodeUtil(root.getTree(testPath));
  node.setNames(JcrConstants.JCR_MIXINTYPES,MIX_REP_ACCESS_CONTROLLABLE);
  AccessControlPolicyIterator itr=acMgr.getApplicablePolicies(testPath);
  assertNotNull(itr);
  assertTrue(itr.hasNext());
}
