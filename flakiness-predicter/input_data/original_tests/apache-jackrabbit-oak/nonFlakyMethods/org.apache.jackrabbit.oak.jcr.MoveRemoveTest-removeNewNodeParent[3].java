@Test public void removeNewNodeParent() throws RepositoryException {
  Session session=getAdminSession();
  session.getRootNode().addNode("parent").addNode("new");
  Node n=session.getNode("/parent/new");
  n.getParent().remove();
  try {
    n.getPath();
    fail();
  }
 catch (  InvalidItemStateException e) {
  }
  session.getRootNode().addNode("parent").addNode("new");
  assertEquals("/parent/new",n.getPath());
}
