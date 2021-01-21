/** 
 * Modifying the jcr:uuid property must fail due to constraint violations.
 */
@Test public void testModifyJcrUuid() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ,PrivilegeConstants.REP_WRITE);
  try {
    Root testRoot=getTestRoot();
    Tree test=testRoot.getTree(referenceablePath);
    test.setProperty(JCR_UUID,"anothervalue");
    testRoot.commit();
    fail("An attempt to change the jcr:uuid property must fail");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isConstraintViolation());
    assertEquals(12,e.getCode());
  }
}
