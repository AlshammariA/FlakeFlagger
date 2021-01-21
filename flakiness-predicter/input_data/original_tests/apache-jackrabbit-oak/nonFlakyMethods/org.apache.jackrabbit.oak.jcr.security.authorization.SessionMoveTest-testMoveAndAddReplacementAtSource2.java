@Test public void testMoveAndAddReplacementAtSource2() throws Exception {
  allow(siblingPath,privilegesFromNames(new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  testSession.move(nodePath3,siblingDestPath);
  Node sourceParent=testSession.getNode(childNPath);
  Node replacement=sourceParent.addNode(Text.getName(nodePath3));
  replacement.setProperty("movedProp","val");
  try {
    testSession.save();
    fail("Missing REMOVE_NODE permission for move source.");
  }
 catch (  AccessDeniedException e) {
  }
}
