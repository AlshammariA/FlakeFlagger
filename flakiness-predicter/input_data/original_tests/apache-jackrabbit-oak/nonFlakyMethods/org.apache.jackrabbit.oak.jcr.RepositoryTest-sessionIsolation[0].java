@Test public void sessionIsolation() throws RepositoryException {
  Session session1=createAdminSession();
  Session session2=createAdminSession();
  try {
    session1.getRootNode().addNode("node1");
    session2.getRootNode().addNode("node2");
    assertTrue(session1.getRootNode().hasNode("node1"));
    assertTrue(session2.getRootNode().hasNode("node2"));
    assertFalse(session1.getRootNode().hasNode("node2"));
    assertFalse(session2.getRootNode().hasNode("node1"));
    session1.save();
    session2.save();
    assertTrue(session1.getRootNode().hasNode("node1"));
    assertTrue(session1.getRootNode().hasNode("node2"));
    assertTrue(session2.getRootNode().hasNode("node1"));
    assertTrue(session2.getRootNode().hasNode("node2"));
  }
  finally {
    session1.logout();
    session2.logout();
  }
}
