@Test public void moveReferenceable() throws RepositoryException {
  Session session=getAdminSession();
  Node node=getNode(TEST_PATH);
  node.addNode("source").addNode("node").addMixin("mix:referenceable");
  node.addNode("target");
  session.save();
  session.refresh(true);
  session.move(TEST_PATH + "/source/node",TEST_PATH + "/target/moved");
  assertFalse(node.hasNode("source/node"));
  assertTrue(node.hasNode("source"));
  assertTrue(node.hasNode("target/moved"));
  session.save();
  assertFalse(node.hasNode("source/node"));
  assertTrue(node.hasNode("source"));
  assertTrue(node.hasNode("target/moved"));
}
