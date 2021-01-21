@Test public void testAddAceWithAcContent() throws Exception {
  NodeUtil acl=createAcl();
  NodeUtil ace=acl.getChild(aceName);
  NodeUtil[] acContent=new NodeUtil[]{ace,ace.getChild(REP_RESTRICTIONS)};
  for (  NodeUtil node : acContent) {
    NodeUtil entry=node.addChild("invalidACE",NT_REP_DENY_ACE);
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
