@Test public void testMoveAndAddAtSourceParent3() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_ADD_CHILD_NODES}));
  allow(childNPath,privilegesFromName(Privilege.JCR_REMOVE_NODE));
  allow(siblingPath,privilegesFromNames(new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_NODE_TYPE_MANAGEMENT}));
  testSession.move(childNPath,siblingDestPath);
  Node sourceParent=testSession.getNode(path);
  sourceParent.addNode(nodeName4);
  testSession.save();
}
