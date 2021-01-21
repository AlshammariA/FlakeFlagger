@Test public void moveExistingParent() throws RepositoryException {
  Session session=getAdminSession();
  session.getRootNode().addNode("parent").addNode("new");
  session.save();
  Node p=session.getNode("/parent");
  Node n=session.getNode("/parent/new");
  session.move("/parent","/moved");
  assertEquals("/moved",p.getPath());
  assertEquals("/moved/new",n.getPath());
}
