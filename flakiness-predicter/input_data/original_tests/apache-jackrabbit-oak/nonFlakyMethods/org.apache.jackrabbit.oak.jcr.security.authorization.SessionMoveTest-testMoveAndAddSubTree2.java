@Test public void testMoveAndAddSubTree2() throws Exception {
  allow(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES));
  allow(childNPath,privilegesFromName(Privilege.JCR_REMOVE_NODE));
  allow(siblingPath,privilegesFromNames(new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  allow(nodePath3,privilegesFromName(Privilege.JCR_ADD_CHILD_NODES));
  testSession.move(childNPath,siblingDestPath);
  Node moved=testSession.getNode(siblingDestPath);
  Node child=moved.getNode(nodeName3);
  child.addNode(nodeName4);
  testSession.save();
}
