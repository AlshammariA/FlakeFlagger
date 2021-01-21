@Test public void sessionRefresh() throws RepositoryException {
  Session session=getAdminSession();
  session.getNode("/").addNode("node1");
  session.getNode("/node1").addNode("node2");
  session.getNode("/").addNode("node1/node3");
  Node node1=session.getNode("/node1");
  assertEquals("/node1",node1.getPath());
  Node node2=session.getNode("/node1/node2");
  assertEquals("/node1/node2",node2.getPath());
  Node node3=session.getNode("/node1/node3");
  assertEquals("/node1/node3",node3.getPath());
  node3.setProperty("property1","value1");
  Item property1=session.getProperty("/node1/node3/property1");
  assertFalse(property1.isNode());
  assertEquals("value1",((Property)property1).getString());
  session.refresh(true);
  assertTrue(session.itemExists("/node1"));
  assertTrue(session.itemExists("/node1/node2"));
  assertTrue(session.itemExists("/node1/node3"));
  assertTrue(session.itemExists("/node1/node3/property1"));
  session.refresh(false);
  assertFalse(session.itemExists("/node1"));
  assertFalse(session.itemExists("/node1/node2"));
  assertFalse(session.itemExists("/node1/node3"));
  assertFalse(session.itemExists("/node1/node3/property1"));
}
