/** 
 * Creating a referenceable tree with an invalid jcr:uuid must fail.
 */
@Test public void testCreateBooleanJcrUuid() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_ADD_CHILD_NODES);
  try {
    Root testRoot=getTestRoot();
    testRoot.refresh();
    NodeUtil a=new NodeUtil(testRoot.getTree("/a"));
    NodeUtil test=a.addChild("referenceable2",NT_NAME);
    test.setBoolean(JcrConstants.JCR_UUID,false);
    testRoot.commit();
    fail("Creating a referenceable node with an boolean uuid must fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isConstraintViolation());
  }
}
