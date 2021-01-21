@Test public void sessionRefreshTrue() throws RepositoryException {
  Session session1=createAdminSession();
  Session session2=createAdminSession();
  try {
    Node foo=session1.getNode("/foo");
    Node added=foo.addNode("added");
    assertTrue(added.isNew());
    session2.getNode("/foo").addNode("bar");
    session2.save();
    session1.refresh(true);
    assertTrue(foo.hasNode("added"));
    assertTrue(foo.getNode("added").isNew());
    assertTrue(foo.hasNode("bar"));
  }
  finally {
    session1.logout();
    session2.logout();
  }
}
