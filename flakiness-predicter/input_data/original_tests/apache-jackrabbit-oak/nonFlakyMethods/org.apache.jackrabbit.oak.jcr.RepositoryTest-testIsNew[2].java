@Test public void testIsNew() throws RepositoryException, InterruptedException {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  Node node1=root.addNode("node1");
  session.save();
  node1.remove();
  Node node2=root.addNode("node2");
  assertTrue("The Node is just added",node2.isNew());
  Node node1Again=root.addNode("node1");
  assertTrue("The Node is just added but has a remove in same commit",node1Again.isNew());
}
