@Test public void testReorderPolicyNode() throws Exception {
  Node n=testSession.getNode(path);
  try {
    if (!n.getPrimaryNodeType().hasOrderableChildNodes()) {
      throw new NotExecutableException("Reordering child nodes is not supported..");
    }
    n.orderBefore(Text.getName(childNPath2),Text.getName(childNPath));
    testSession.save();
    fail("test session must not be allowed to reorder nodes.");
  }
 catch (  AccessDeniedException e) {
  }
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_ALL}));
  n.orderBefore(Text.getName(childNPath2),Text.getName(childNPath));
  testSession.save();
  n.orderBefore("rep:policy",Text.getName(childNPath2));
  testSession.save();
}
