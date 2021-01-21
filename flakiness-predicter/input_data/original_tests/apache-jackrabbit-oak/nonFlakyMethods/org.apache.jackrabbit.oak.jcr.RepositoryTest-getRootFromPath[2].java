@Test public void getRootFromPath() throws RepositoryException {
  Node root=getNode("/");
  assertEquals("",root.getName());
  assertEquals("/",root.getPath());
}
