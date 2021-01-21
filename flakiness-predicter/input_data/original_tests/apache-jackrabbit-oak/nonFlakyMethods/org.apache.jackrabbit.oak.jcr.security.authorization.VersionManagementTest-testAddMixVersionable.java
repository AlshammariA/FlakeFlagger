@Test public void testAddMixVersionable() throws Exception {
  modify(path,REP_WRITE,true);
  modify(path,Privilege.JCR_VERSION_MANAGEMENT,false);
  Node testNode=testSession.getNode(path);
  try {
    createVersionableNode(testNode);
    fail("Test session does not have permission to add mixins -> no version content should be created.");
  }
 catch (  AccessDeniedException e) {
    assertFalse(testNode.isNodeType(mixVersionable));
    assertFalse(testNode.hasProperty("jcr:isCheckedOut"));
    assertFalse(testNode.hasProperty(jcrVersionHistory));
  }
}
