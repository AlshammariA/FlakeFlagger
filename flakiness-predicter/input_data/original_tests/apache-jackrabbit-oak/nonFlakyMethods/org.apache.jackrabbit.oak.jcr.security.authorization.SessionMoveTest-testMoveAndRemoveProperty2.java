@Test public void testMoveAndRemoveProperty2() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_REMOVE_NODE,Privilege.JCR_REMOVE_CHILD_NODES,PrivilegeConstants.REP_REMOVE_PROPERTIES}));
  allow(siblingPath,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  testSession.move(nodePath3,siblingDestPath);
  Node destNode=testSession.getNode(siblingDestPath);
  destNode.getProperty("movedProp").remove();
  testSession.save();
}
