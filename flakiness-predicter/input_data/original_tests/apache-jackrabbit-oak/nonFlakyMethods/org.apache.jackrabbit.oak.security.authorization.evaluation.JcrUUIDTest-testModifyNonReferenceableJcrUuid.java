/** 
 * Creating a non-referenceable tree with a jcr:uuid must fail with AccessDeniedException unless the REP_ADD_PROPERTY privilege is granted
 */
@Test public void testModifyNonReferenceableJcrUuid() throws Exception {
  NodeUtil a=new NodeUtil(root.getTree("/a"));
  a.setString(JCR_UUID,"some-value");
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_ADD_CHILD_NODES);
  try {
    Root testRoot=getTestRoot();
    a=new NodeUtil(testRoot.getTree("/a"));
    assertNotNull(a.getString(JCR_UUID,null));
    a.setString(JCR_UUID,IdentifierManager.generateUUID());
    testRoot.commit();
    fail("Modifying a jcr:uuid property for an unstructured node without MODIFY_PROPERTY permission must fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessViolation());
  }
}
