@Test public void move() throws RepositoryException {
  Session session=getAdminSession();
  Node node=getNode(TEST_PATH);
  Node source=node.addNode("source").addNode("node");
  node.addNode("target");
  session.save();
  session.refresh(true);
  session.move(TEST_PATH + "/source/node",TEST_PATH + "/target/moved");
  assertEquals(TEST_PATH + "/target/moved",source.getPath());
  assertFalse(node.hasNode("source/node"));
  assertTrue(node.hasNode("source"));
  assertTrue(node.hasNode("target/moved"));
  session.save();
  assertFalse(node.hasNode("source/node"));
  assertTrue(node.hasNode("source"));
  assertTrue(node.hasNode("target/moved"));
}
