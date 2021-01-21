@Test public void testPolicyWithOutChildOrder() throws AccessDeniedException {
  NodeUtil testRoot=getTestRoot();
  testRoot.setNames(JcrConstants.JCR_MIXINTYPES,MIX_REP_ACCESS_CONTROLLABLE);
  testRoot.addChild(REP_POLICY,NT_REP_ACL);
  try {
    root.commit();
    fail("Policy node with child node ordering");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessControlViolation());
    assertEquals("OakAccessControl0004: Invalid policy node: Order of children is not stable.",e.getMessage());
  }
}
