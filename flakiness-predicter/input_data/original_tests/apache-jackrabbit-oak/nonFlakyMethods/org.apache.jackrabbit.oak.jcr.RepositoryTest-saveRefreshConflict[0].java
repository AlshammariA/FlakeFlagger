@Test public void saveRefreshConflict() throws RepositoryException {
  Session session1=createAdminSession();
  Session session2=createAdminSession();
  try {
    session1.getRootNode().addNode("node").setProperty("p","v1");
    session2.getRootNode().addNode("node").setProperty("p","v2");
    assertTrue(session1.getRootNode().hasNode("node"));
    assertTrue(session2.getRootNode().hasNode("node"));
    session1.save();
    assertTrue(session1.getRootNode().hasNode("node"));
    assertTrue(session2.getRootNode().hasNode("node"));
    session2.refresh(true);
    assertTrue(session1.getRootNode().hasNode("node"));
    assertTrue(session2.getRootNode().hasNode("node"));
    try {
      session2.save();
      fail("Expected InvalidItemStateException");
    }
 catch (    InvalidItemStateException expected) {
    }
  }
  finally {
    session1.logout();
    session2.logout();
  }
}
