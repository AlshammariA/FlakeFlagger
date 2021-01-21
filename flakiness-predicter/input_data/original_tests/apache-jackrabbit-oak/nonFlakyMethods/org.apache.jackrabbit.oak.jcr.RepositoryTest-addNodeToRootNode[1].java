@Test public void addNodeToRootNode() throws RepositoryException {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  String newNode="newNodeBelowRoot";
  assertFalse(root.hasNode(newNode));
  root.addNode(newNode);
  session.save();
}
