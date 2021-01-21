@Test public void testAddInvalidRepoPolicy() throws Exception {
  NodeUtil testRoot=getTestRoot();
  testRoot.setNames(JcrConstants.JCR_MIXINTYPES,MIX_REP_ACCESS_CONTROLLABLE);
  NodeUtil policy=getTestRoot().addChild(REP_REPO_POLICY,NT_REP_ACL);
  try {
    root.commit();
    fail("Attempt to add repo-policy with rep:AccessControllable node.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessControlViolation());
  }
 finally {
    policy.getTree().remove();
  }
}
