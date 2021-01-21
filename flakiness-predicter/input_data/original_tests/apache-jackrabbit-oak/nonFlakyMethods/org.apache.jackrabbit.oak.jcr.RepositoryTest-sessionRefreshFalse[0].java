@Test public void sessionRefreshFalse() throws RepositoryException {
  Session session1=createAdminSession();
  Session session2=createAdminSession();
  try {
    Node foo=session1.getNode("/foo");
    foo.addNode("added");
    session2.getNode("/foo").addNode("bar");
    session2.save();
    session1.refresh(false);
    assertFalse(foo.hasNode("added"));
    assertTrue(foo.hasNode("bar"));
  }
  finally {
    session1.logout();
    session2.logout();
  }
}
