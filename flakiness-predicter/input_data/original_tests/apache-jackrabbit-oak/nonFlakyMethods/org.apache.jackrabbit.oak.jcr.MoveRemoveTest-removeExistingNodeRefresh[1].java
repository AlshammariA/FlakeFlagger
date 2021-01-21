@Test public void removeExistingNodeRefresh() throws RepositoryException {
  Session session=getAdminSession();
  session.getRootNode().addNode("new");
  session.save();
  Session session2=createAdminSession();
  Node n2=session2.getNode("/new");
  Node n=session.getNode("/new");
  n.remove();
  session.save();
  session2.refresh(false);
  try {
    n2.getPath();
    fail();
  }
 catch (  InvalidItemStateException e) {
  }
  session.getRootNode().addNode("new");
  session.save();
  session2.refresh(false);
  assertEquals("/new",n2.getPath());
  session2.logout();
}
