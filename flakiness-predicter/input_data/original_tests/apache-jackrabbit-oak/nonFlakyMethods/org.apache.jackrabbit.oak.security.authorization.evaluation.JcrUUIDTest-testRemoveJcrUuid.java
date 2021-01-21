/** 
 * Removing the jcr:uuid property must fail due to constraint violations.
 */
@Test public void testRemoveJcrUuid() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ);
  try {
    Root testRoot=getTestRoot();
    Tree test=testRoot.getTree(referenceablePath);
    test.removeProperty(JCR_UUID);
    testRoot.commit();
    fail("Removing the jcr:uuid property of a referenceable node must fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isConstraintViolation());
    assertEquals(22,e.getCode());
  }
}
