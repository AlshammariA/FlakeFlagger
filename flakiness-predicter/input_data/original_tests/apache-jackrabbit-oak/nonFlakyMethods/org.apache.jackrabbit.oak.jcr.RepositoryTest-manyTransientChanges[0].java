@Test public void manyTransientChanges() throws RepositoryException {
  Session session=getAdminSession();
  Node test=session.getRootNode().getNode(TEST_NODE);
  Node foo=test.addNode("foo");
  session.save();
  test.setProperty("p","value");
  for (int i=0; i < 76; i++) {
    test.addNode("n" + i);
  }
  Node t=foo.addNode("test");
  t.setProperty("prop","value");
  session.getNode(TEST_PATH + "/foo/test").setProperty("prop","value");
  session.save();
  session.logout();
}
