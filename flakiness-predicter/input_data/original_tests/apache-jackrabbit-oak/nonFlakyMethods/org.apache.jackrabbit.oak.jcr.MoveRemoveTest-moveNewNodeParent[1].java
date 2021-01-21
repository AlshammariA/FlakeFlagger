@Test public void moveNewNodeParent() throws RepositoryException {
  Session session=getAdminSession();
  session.getRootNode().addNode("parent").addNode("new");
  Node n=session.getNode("/parent/new");
  session.move("/parent","/moved");
  assertEquals("/moved/new",n.getPath());
}
