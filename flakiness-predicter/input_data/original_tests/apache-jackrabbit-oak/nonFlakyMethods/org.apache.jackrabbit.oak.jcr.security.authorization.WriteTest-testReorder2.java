@Test public void testReorder2() throws Exception {
  Node n=testSession.getNode(path);
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  try {
    n.orderBefore(Text.getName(childNPath2),Text.getName(childNPath));
    testSession.save();
    fail("test session must not be allowed to reorder nodes.");
  }
 catch (  AccessDeniedException e) {
  }
}
