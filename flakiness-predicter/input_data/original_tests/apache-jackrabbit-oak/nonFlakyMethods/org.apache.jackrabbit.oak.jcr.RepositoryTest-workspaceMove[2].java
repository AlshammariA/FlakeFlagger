@Test public void workspaceMove() throws RepositoryException {
  Session session=getAdminSession();
  Node node=getNode(TEST_PATH);
  node.addNode("source").addNode("node");
  node.addNode("target");
  session.save();
  session.getWorkspace().move(TEST_PATH + "/source/node",TEST_PATH + "/target/moved");
  assertFalse(node.hasNode("source/node"));
  assertTrue(node.hasNode("source"));
  assertTrue(node.hasNode("target/moved"));
}
