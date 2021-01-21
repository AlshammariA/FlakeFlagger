@Test public void getNodeDot() throws RepositoryException {
  Node node=getNode("/foo");
  Node same=node.getNode(".");
  assertNotNull(same);
  assertEquals("foo",same.getName());
  assertTrue(same.isSame(node));
}
