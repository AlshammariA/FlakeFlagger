@Test public void removeNode() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  parentNode.addNode("newNode");
  parentNode.getSession().save();
  Session session2=createAdminSession();
  try {
    Node removeNode=session2.getNode(TEST_PATH + "/newNode");
    removeNode.remove();
    try {
      removeNode.getParent();
      fail("Cannot retrieve the parent from a transiently removed item.");
    }
 catch (    InvalidItemStateException expected) {
    }
    assertTrue(session2.getNode(TEST_PATH).isModified());
    session2.save();
  }
  finally {
    session2.logout();
  }
  Session session3=createAnonymousSession();
  try {
    assertFalse(session3.nodeExists(TEST_PATH + "/newNode"));
    assertFalse(session3.getNode(TEST_PATH).isModified());
  }
  finally {
    session3.logout();
  }
}
