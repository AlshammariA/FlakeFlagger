@Test public void oak962() throws RepositoryException {
  Session session=getAdminSession();
  Node root=session.getRootNode().addNode("root");
  root.addNode("N3");
  root.addNode("N6").addNode("N7");
  session.save();
  session.move("/root/N6/N7","/root/N3/N12");
  root.getNode("N3").getNode("N12").remove();
  root.getNode("N6").remove();
  session.save();
}
