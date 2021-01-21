@Test public void testRemoveBySetProperty() throws RepositoryException {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  try {
    root.setProperty("test","abc");
    assertNotNull(root.setProperty("test",(String)null));
  }
 catch (  PathNotFoundException e) {
  }
}
