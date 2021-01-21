@Test public void testReorder() throws Exception {
  Node n=testSession.getNode(path);
  if (!n.getPrimaryNodeType().hasOrderableChildNodes()) {
    throw new NotExecutableException("Reordering child nodes is not supported..");
  }
  try {
    n.orderBefore(Text.getName(childNPath2),Text.getName(childNPath));
    testSession.save();
    fail("test session must not be allowed to reorder nodes.");
  }
 catch (  AccessDeniedException e) {
  }
}
