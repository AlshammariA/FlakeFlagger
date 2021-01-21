@Test public void testAddNodeWithExpandedName() throws RepositoryException {
  Session session=getAdminSession();
  session.getWorkspace().getNamespaceRegistry().registerNamespace("foo","http://foo");
  Node node=getNode(TEST_PATH);
  Node added=node.addNode("{http://foo}new");
  assertEquals("foo:new",added.getName());
  session.save();
  added=session.getNode(TEST_PATH + "/{http://foo}new");
  assertEquals("foo:new",added.getName());
}
