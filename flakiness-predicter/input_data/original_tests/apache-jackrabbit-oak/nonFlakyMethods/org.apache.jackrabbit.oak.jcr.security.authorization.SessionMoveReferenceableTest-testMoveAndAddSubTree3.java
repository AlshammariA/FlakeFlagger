@Test public void testMoveAndAddSubTree3() throws Exception {
  allow(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES));
  allow(childNPath,privilegesFromNames(new String[]{Privilege.JCR_REMOVE_NODE,Privilege.JCR_ADD_CHILD_NODES}));
  allow(siblingPath,privilegesFromNames(new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  testSession.move(childNPath,siblingDestPath);
  Node moved=testSession.getNode(siblingDestPath);
  Node child=moved.getNode(nodeName3);
  child.addNode(nodeName4);
  testSession.save();
}
