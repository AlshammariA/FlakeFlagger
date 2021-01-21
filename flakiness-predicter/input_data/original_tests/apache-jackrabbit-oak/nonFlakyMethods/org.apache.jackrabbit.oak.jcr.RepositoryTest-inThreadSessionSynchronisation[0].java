@Test public void inThreadSessionSynchronisation() throws RepositoryException {
  Session session1=createAdminSession();
  Session session2=createAdminSession();
  Session session3=createAdminSession();
  try {
    session1.getRootNode().addNode("newNode");
    session1.save();
    assertTrue(session2.nodeExists("/newNode"));
    assertTrue(session3.nodeExists("/newNode"));
  }
  finally {
    session1.logout();
    session2.logout();
    session3.logout();
  }
}
