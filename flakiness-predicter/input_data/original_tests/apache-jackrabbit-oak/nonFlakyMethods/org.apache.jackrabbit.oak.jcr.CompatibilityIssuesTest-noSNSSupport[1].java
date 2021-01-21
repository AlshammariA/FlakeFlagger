@Test public void noSNSSupport() throws RepositoryException {
  Session session=getAdminSession();
  Node testNode=session.getRootNode().addNode("test","nt:unstructured");
  session.save();
  testNode.addNode("foo");
  try {
    testNode.addNode("foo");
    fail("Expected ItemExistsException");
  }
 catch (  ItemExistsException e) {
  }
  session.save();
  try {
    testNode.addNode("foo");
    fail("Expected ItemExistsException");
  }
 catch (  ItemExistsException e) {
  }
}
