@Test public void testSpaceInNames() throws RepositoryException {
  Node n=session.getRootNode().addNode("c o n t e n t");
  session.getNode(n.getPath());
}
