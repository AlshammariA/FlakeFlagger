@Test public void removeExistingNodeRefreshParent() throws RepositoryException {
  Session session=getAdminSession();
  session.getRootNode().addNode("parent").addNode("new");
  session.save();
  Session session2=createAdminSession();
  Node n2=session2.getNode("/parent/new");
  Node n=session.getNode("/parent/new");
  n.getParent().remove();
  session.save();
  session2.refresh(false);
  try {
    n2.getPath();
    fail();
  }
 catch (  InvalidItemStateException e) {
  }
  session.getRootNode().addNode("parent").addNode("new");
  session.save();
  session2.refresh(false);
  assertEquals("/parent/new",n2.getPath());
  session2.logout();
}
