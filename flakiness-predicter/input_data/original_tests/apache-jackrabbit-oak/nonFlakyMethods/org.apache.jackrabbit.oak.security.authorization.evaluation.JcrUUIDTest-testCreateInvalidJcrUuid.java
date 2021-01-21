/** 
 * Creating a referenceable tree with an invalid jcr:uuid must fail.
 */
@Test public void testCreateInvalidJcrUuid() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_ADD_CHILD_NODES);
  try {
    Root testRoot=getTestRoot();
    testRoot.refresh();
    NodeUtil a=new NodeUtil(testRoot.getTree("/a"));
    NodeUtil test=a.addChild("referenceable2",NT_NAME);
    test.setString(JcrConstants.JCR_UUID,"not a uuid");
    testRoot.commit();
    fail("Creating a referenceable node with an invalid uuid must fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isConstraintViolation());
    assertEquals(12,e.getCode());
  }
}
