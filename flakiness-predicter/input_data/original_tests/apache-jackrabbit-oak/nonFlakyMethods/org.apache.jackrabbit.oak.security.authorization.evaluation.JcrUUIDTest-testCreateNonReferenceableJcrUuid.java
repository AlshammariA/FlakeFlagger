/** 
 * Creating a non-referenceable tree with an jcr:uuid must fail with AccessDeniedException unless the REP_ADD_PROPERTY privilege is granted
 */
@Test public void testCreateNonReferenceableJcrUuid() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_ADD_CHILD_NODES);
  try {
    Root testRoot=getTestRoot();
    NodeUtil a=new NodeUtil(testRoot.getTree("/a"));
    a.setString(JCR_UUID,IdentifierManager.generateUUID());
    testRoot.commit();
    fail("Creating a jcr:uuid property for an unstructured node without ADD_PROPERTY permission must fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessViolation());
  }
}
