@Test public void setPrimaryType() throws RepositoryException {
  Node testNode=getNode(TEST_PATH);
  assertEquals("nt:unstructured",testNode.getPrimaryNodeType().getName());
  assertEquals("nt:unstructured",testNode.getProperty("jcr:primaryType").getString());
  testNode.setPrimaryType("nt:folder");
  getAdminSession().save();
  Session session2=createAnonymousSession();
  try {
    testNode=session2.getNode(TEST_PATH);
    assertEquals("nt:folder",testNode.getPrimaryNodeType().getName());
    assertEquals("nt:folder",testNode.getProperty("jcr:primaryType").getString());
  }
  finally {
    session2.logout();
  }
}
