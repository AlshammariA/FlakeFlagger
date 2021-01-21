@Test public void getRoot() throws RepositoryException {
  Node root=getAdminSession().getRootNode();
  assertNotNull(root);
  assertEquals("",root.getName());
  assertEquals("/",root.getPath());
}
