@Test public void addNode() throws RepositoryException {
  Session session=getAdminSession();
  String newNode=TEST_PATH + "/new";
  assertFalse(session.nodeExists(newNode));
  Node node=getNode(TEST_PATH);
  Node added=node.addNode("new");
  assertFalse(node.isNew());
  assertTrue(node.isModified());
  assertTrue(added.isNew());
  assertFalse(added.isModified());
  session.save();
  Session session2=createAnonymousSession();
  try {
    assertTrue(session2.nodeExists(newNode));
    added=session2.getNode(newNode);
    assertFalse(added.isNew());
    assertFalse(added.isModified());
  }
  finally {
    session2.logout();
  }
}
