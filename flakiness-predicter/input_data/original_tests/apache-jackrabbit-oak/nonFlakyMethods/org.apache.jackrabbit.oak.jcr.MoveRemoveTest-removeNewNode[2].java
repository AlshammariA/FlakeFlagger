@Test public void removeNewNode() throws RepositoryException {
  Session session=getAdminSession();
  session.getRootNode().addNode("new");
  Node n=session.getNode("/new");
  n.remove();
  try {
    n.getPath();
    fail();
  }
 catch (  InvalidItemStateException e) {
  }
  session.getRootNode().addNode("new");
  assertEquals("/new",n.getPath());
}
