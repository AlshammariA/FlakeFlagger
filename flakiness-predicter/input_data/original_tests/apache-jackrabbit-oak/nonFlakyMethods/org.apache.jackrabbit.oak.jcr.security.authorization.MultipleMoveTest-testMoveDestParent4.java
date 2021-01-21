@Ignore("Known Limitation of OAK-710") @Test public void testMoveDestParent4() throws Exception {
  allow(testRootNode.getPath(),privilegesFromNames(new String[]{Privilege.JCR_REMOVE_NODE,Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  move(childNPath,siblingDestPath);
  move(siblingPath,childNPath);
  testSession.save();
}
