@Test public void getNodeByUUID() throws RepositoryException {
  Node node=getNode("/foo").addNode("boo");
  node.addMixin(JcrConstants.MIX_REFERENCEABLE);
  assertTrue(node.isNodeType(JcrConstants.MIX_REFERENCEABLE));
  String uuid=node.getUUID();
  assertNotNull(uuid);
  assertEquals(uuid,node.getIdentifier());
  Node nAgain=node.getSession().getNodeByUUID(uuid);
  assertTrue(nAgain.isSame(node));
  assertTrue(nAgain.isSame(node.getSession().getNodeByIdentifier(uuid)));
  Node childNode=node.addNode("boohoo");
  childNode.addMixin(JcrConstants.MIX_REFERENCEABLE);
  assertTrue(childNode.isNodeType(JcrConstants.MIX_REFERENCEABLE));
  String childUuid=childNode.getUUID();
  assertNotNull(childUuid);
  assertEquals(childUuid,childNode.getIdentifier());
  nAgain=childNode.getSession().getNodeByUUID(childUuid);
  assertTrue(nAgain.isSame(childNode));
  assertTrue(nAgain.isSame(childNode.getSession().getNodeByIdentifier(childUuid)));
  node.getSession().move("/foo/boo","/foo/boohoo");
  node=getNode("/foo/boohoo");
  nAgain=node.getSession().getNodeByUUID(uuid);
  assertTrue(nAgain.isSame(node));
  assertTrue(nAgain.isSame(node.getSession().getNodeByIdentifier(uuid)));
}
