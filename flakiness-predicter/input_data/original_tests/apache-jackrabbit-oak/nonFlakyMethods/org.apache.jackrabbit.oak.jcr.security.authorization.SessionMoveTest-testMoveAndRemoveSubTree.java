@Test public void testMoveAndRemoveSubTree() throws Exception {
  allow(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES));
  allow(siblingPath,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  testSession.move(childNPath,siblingDestPath);
  Node moved=testSession.getNode(siblingDestPath);
  Node child=moved.getNode(nodeName3);
  try {
    child.remove();
    testSession.save();
    fail("Removing subtree after move requires 'jcr:removeNode' privilege on the target");
  }
 catch (  AccessDeniedException e) {
  }
}
