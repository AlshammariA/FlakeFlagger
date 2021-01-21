@Test public void saveConflict() throws RepositoryException {
  getAdminSession().getRootNode().addNode("node");
  getAdminSession().save();
  Session session1=createAdminSession();
  Session session2=createAdminSession();
  try {
    session1.getNode("/node").remove();
    session2.getNode("/node").addNode("2");
    assertFalse(session1.getRootNode().hasNode("node"));
    assertTrue(session2.getRootNode().hasNode("node"));
    assertTrue(session2.getRootNode().getNode("node").hasNode("2"));
    session1.save();
    assertFalse(session1.getRootNode().hasNode("node"));
    assertFalse(session2.getRootNode().hasNode("node"));
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
