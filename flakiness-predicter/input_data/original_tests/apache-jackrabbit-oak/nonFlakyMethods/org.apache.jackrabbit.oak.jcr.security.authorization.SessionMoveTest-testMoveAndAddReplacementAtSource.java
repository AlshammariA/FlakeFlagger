@Test public void testMoveAndAddReplacementAtSource() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_ADD_CHILD_NODES}));
  allow(siblingPath,privilegesFromNames(new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  testSession.move(nodePath3,siblingDestPath);
  Node sourceParent=testSession.getNode(childNPath);
  Node replacement=sourceParent.addNode(Text.getName(nodePath3));
  replacement.setProperty("movedProp","val");
  try {
    testSession.save();
    fail("Missing ADD_NODE and ADD_PROPERTY permission on source parent.");
  }
 catch (  AccessDeniedException e) {
  }
}
