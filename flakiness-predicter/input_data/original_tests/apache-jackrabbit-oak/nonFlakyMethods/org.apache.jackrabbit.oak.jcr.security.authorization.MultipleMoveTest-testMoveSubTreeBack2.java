@Test public void testMoveSubTreeBack2() throws Exception {
  allow(testRootNode.getPath(),privilegesFromNames(new String[]{Privilege.JCR_REMOVE_NODE,Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  move(childNPath,siblingDestPath);
  move(siblingDestPath + '/' + nodeName3,path + "/subtreeBack");
  testSession.save();
}
