@Test public void testRename2() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  Node child=testSession.getNode(childNPath);
  try {
    ((JackrabbitNode)child).rename("rename");
    testSession.save();
    fail("test session must not be allowed to rename nodes.");
  }
 catch (  AccessDeniedException e) {
  }
}
