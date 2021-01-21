@Test public void getNodeByIdentifier() throws RepositoryException {
  Node node=getNode("/foo");
  String id=node.getIdentifier();
  Node node2=getAdminSession().getNodeByIdentifier(id);
  assertTrue(node.isSame(node2));
}
