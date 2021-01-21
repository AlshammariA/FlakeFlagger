@Test public void testMoveAndRemoveSubTree2() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_REMOVE_NODE}));
  allow(siblingPath,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  deny(testSession.getNode(nodePath3).getPath(),privilegesFromName(Privilege.JCR_REMOVE_NODE));
  try {
    testSession.move(childNPath,siblingDestPath);
    Node moved=testSession.getNode(siblingDestPath);
    Node child=moved.getNode(nodeName3);
    child.remove();
    testSession.save();
    fail("Removing subtree after move requires 'jcr:removeNode' on the removed child.");
  }
 catch (  AccessDeniedException e) {
  }
}
