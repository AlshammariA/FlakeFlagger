@Test public void testMoveAndAddAtSourceParent() throws Exception {
  allow(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES));
  allow(childNPath,privilegesFromName(Privilege.JCR_REMOVE_NODE));
  allow(siblingPath,privilegesFromNames(new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  testSession.move(childNPath,siblingDestPath);
  Node sourceParent=testSession.getNode(path);
  sourceParent.addNode(nodeName4);
  try {
    testSession.save();
    fail("Adding child node at source parent be denied: missing add_child_node privilege.");
  }
 catch (  AccessDeniedException e) {
  }
}
