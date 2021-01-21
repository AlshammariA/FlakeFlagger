@Test public void testAddIsolatedRestriction() throws Exception {
  NodeUtil node=getTestRoot();
  NodeUtil restriction=node.addChild("isolatedRestriction",NT_REP_RESTRICTIONS);
  try {
    root.commit();
    fail("Writing an isolated Restriction should fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessControlViolation());
  }
 finally {
    restriction.getTree().remove();
  }
}
