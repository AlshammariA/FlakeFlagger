@Test public void testAddRestrictionWithAcContent() throws Exception {
  NodeUtil acl=createAcl();
  NodeUtil ace=acl.getChild(aceName);
  NodeUtil[] acContent=new NodeUtil[]{acl,ace.getChild(REP_RESTRICTIONS)};
  for (  NodeUtil node : acContent) {
    NodeUtil entry=node.addChild("invalidRestriction",NT_REP_RESTRICTIONS);
    try {
      root.commit();
      fail("Adding an ACE below an ACE or restriction should fail");
    }
 catch (    CommitFailedException e) {
      assertTrue(e.isConstraintViolation());
    }
 finally {
      entry.getTree().remove();
    }
  }
}
