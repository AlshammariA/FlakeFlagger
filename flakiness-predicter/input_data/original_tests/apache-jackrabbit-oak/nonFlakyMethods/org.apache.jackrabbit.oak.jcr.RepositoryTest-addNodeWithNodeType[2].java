@Test public void addNodeWithNodeType() throws RepositoryException {
  Session session=getAdminSession();
  Node node=getNode(TEST_PATH);
  node.addNode("new","nt:folder");
  session.save();
}
