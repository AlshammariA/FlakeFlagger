@Test(expected=RepositoryException.class) public void moveToDescendant() throws RepositoryException {
  Session session=getAdminSession();
  Node node=getNode(TEST_PATH);
  Node source=node.addNode("s");
  session.save();
  session.refresh(true);
  session.move(TEST_PATH + "/s",TEST_PATH + "/s/t");
}
