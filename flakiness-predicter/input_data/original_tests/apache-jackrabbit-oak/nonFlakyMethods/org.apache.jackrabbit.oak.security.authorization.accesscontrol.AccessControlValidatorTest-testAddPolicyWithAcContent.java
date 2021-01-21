@Test public void testAddPolicyWithAcContent() throws Exception {
  NodeUtil acl=createAcl();
  NodeUtil ace=acl.getChild(aceName);
  NodeUtil[] acContent=new NodeUtil[]{acl,ace,ace.getChild(REP_RESTRICTIONS)};
  for (  NodeUtil node : acContent) {
    NodeUtil policy=node.addChild(REP_POLICY,NT_REP_ACL);
    try {
      root.commit();
      fail("Adding an ACL below access control content should fail");
    }
 catch (    CommitFailedException e) {
      assertTrue(e.isConstraintViolation());
    }
 finally {
      policy.getTree().remove();
    }
  }
}
