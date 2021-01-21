@Test public void testAddIsolatedPolicy() throws Exception {
  String[] policyNames=new String[]{"isolatedACL",REP_POLICY,REP_REPO_POLICY};
  NodeUtil node=getTestRoot();
  for (  String policyName : policyNames) {
    NodeUtil policy=node.addChild(policyName,NT_REP_ACL);
    try {
      root.commit();
      fail("Writing an isolated ACL without the parent being rep:AccessControllable should fail.");
    }
 catch (    CommitFailedException e) {
      assertTrue(e.isAccessControlViolation());
    }
 finally {
      policy.getTree().remove();
    }
  }
}
