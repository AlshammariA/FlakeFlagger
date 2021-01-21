@Test(expected=ItemExistsException.class) public void testAddNodeDot() throws RepositoryException {
  Node node=getNode("/foo");
  node.addNode("..");
}
