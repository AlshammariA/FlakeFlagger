@Test public void moveNewNode() throws RepositoryException {
  Session session=getAdminSession();
  session.getRootNode().addNode("new");
  Node n=session.getNode("/new");
  session.move("/new","/moved");
  assertEquals("/moved",n.getPath());
}
