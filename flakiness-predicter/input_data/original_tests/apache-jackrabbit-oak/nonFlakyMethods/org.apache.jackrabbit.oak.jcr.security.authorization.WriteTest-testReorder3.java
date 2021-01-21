@Test public void testReorder3() throws Exception {
  Node n=testSession.getNode(path);
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  n.orderBefore(Text.getName(childNPath2),Text.getName(childNPath));
  testSession.save();
}
