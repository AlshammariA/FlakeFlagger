@Test public void move() throws RepositoryException {
  Session session=getAdminSession();
  Node node=session.getNode("/");
  node.addNode("source").addNode("node");
  node.addNode("target");
  session.save();
  session.refresh(true);
  Node sourceNode=session.getNode("/source/node");
  session.move("/source/node","/target/moved");
  try {
    sourceNode.getPath();
  }
 catch (  InvalidItemStateException expected) {
  }
}
