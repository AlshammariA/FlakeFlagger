@Test public void expandedName() throws RepositoryException {
  Session session=getAdminSession();
  session.setNamespacePrefix("foo","http://example.com/");
  session.getRootNode().addNode("{0} test");
  session.save();
  assertTrue(session.nodeExists("/{0} test"));
}
