@Test public void testRemoveBySetMVProperty() throws RepositoryException {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  try {
    root.setProperty("test",new String[]{"abc","def"});
    assertNotNull(root.setProperty("test",(String[])null));
  }
 catch (  PathNotFoundException e) {
  }
}
