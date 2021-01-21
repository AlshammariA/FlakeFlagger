@Test public void testRename() throws Exception {
  Node child=testSession.getNode(childNPath);
  try {
    ((JackrabbitNode)child).rename("rename");
    testSession.save();
    fail("test session must not be allowed to rename nodes.");
  }
 catch (  AccessDeniedException e) {
  }
}
