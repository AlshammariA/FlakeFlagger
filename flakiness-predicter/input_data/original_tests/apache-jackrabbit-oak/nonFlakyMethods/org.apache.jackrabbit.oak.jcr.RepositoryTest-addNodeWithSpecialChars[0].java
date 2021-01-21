@Test public void addNodeWithSpecialChars() throws RepositoryException {
  Session session=getAdminSession();
  String nodeName="foo{";
  String newNode=TEST_PATH + '/' + nodeName;
  assertFalse(session.nodeExists(newNode));
  Node node=getNode(TEST_PATH);
  node.addNode(nodeName);
  session.save();
  Session session2=createAnonymousSession();
  try {
    assertTrue(session2.nodeExists(newNode));
  }
  finally {
    session2.logout();
  }
}
