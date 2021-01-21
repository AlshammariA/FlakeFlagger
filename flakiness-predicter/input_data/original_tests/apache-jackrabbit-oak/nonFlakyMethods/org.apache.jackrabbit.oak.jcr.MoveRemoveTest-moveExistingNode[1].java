@Test public void moveExistingNode() throws RepositoryException {
  Session session=getAdminSession();
  session.getRootNode().addNode("new");
  session.save();
  Node n=session.getNode("/new");
  session.move("/new","/moved");
  assertEquals("/moved",n.getPath());
}
