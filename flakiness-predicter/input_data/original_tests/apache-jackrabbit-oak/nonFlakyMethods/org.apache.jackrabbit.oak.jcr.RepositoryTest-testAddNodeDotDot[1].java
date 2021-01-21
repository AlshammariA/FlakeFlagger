@Test(expected=ItemExistsException.class) public void testAddNodeDotDot() throws RepositoryException {
  Node node=getNode("/foo");
  node.addNode(".");
}
