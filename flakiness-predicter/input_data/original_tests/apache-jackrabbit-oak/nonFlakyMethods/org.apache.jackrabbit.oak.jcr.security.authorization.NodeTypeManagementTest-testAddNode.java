/** 
 * Test difference between common jcr:write privilege an rep:write privilege that includes the ability to set the primary node type upon child node creation.
 */
@Test public void testAddNode() throws Exception {
  modify(childNode.getPath(),Privilege.JCR_WRITE,true);
  addChildNode(false);
  try {
    addChildNode(true);
    fail("Missing privilege jcr:nodeTypeManagement.");
  }
 catch (  AccessDeniedException e) {
  }
  modify(childNode.getPath(),Privilege.JCR_NODE_TYPE_MANAGEMENT,true);
  addChildNode(false);
  addChildNode(true);
}
