@Test public void testMoveAndAddSubTree() throws Exception {
  allow(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES));
  allow(childNPath,privilegesFromName(Privilege.JCR_REMOVE_NODE));
  allow(siblingPath,privilegesFromNames(new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  testSession.move(childNPath,siblingDestPath);
  Node moved=testSession.getNode(siblingDestPath);
  Node child=moved.getNode(nodeName3);
  child.addNode(nodeName4);
  try {
    testSession.save();
    fail("Adding child node at moved node must be denied: no add_child_node privilege at original location.");
  }
 catch (  AccessDeniedException e) {
  }
}
