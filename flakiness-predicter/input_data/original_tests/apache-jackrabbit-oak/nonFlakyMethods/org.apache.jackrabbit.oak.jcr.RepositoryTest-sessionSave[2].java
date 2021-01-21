@Test public void sessionSave() throws RepositoryException {
  Session session1=createAdminSession();
  Session session2=createAdminSession();
  try {
    session1.getNode("/").addNode("node1");
    session1.getNode("/node1").addNode("node2");
    session1.getNode("/").addNode("node1/node3");
    Node node1=session1.getNode("/node1");
    assertEquals("/node1",node1.getPath());
    Node node2=session1.getNode("/node1/node2");
    assertEquals("/node1/node2",node2.getPath());
    Node node3=session1.getNode("/node1/node3");
    assertEquals("/node1/node3",node3.getPath());
    node3.setProperty("property1","value1");
    Item property1=session1.getProperty("/node1/node3/property1");
    assertFalse(property1.isNode());
    assertEquals("value1",((Property)property1).getString());
    assertFalse(session2.itemExists("/node1"));
    assertFalse(session2.itemExists("/node1/node2"));
    assertFalse(session2.itemExists("/node1/node3"));
    assertFalse(session2.itemExists("/node1/node3/property1"));
    session1.save();
    assertTrue(session2.itemExists("/node1"));
    assertTrue(session2.itemExists("/node1/node2"));
    assertTrue(session2.itemExists("/node1/node3"));
    assertTrue(session2.itemExists("/node1/node3/property1"));
    session2.refresh(false);
    assertTrue(session2.itemExists("/node1"));
    assertTrue(session2.itemExists("/node1/node2"));
    assertTrue(session2.itemExists("/node1/node3"));
    assertTrue(session2.itemExists("/node1/node3/property1"));
  }
  finally {
    session1.logout();
    session2.logout();
  }
}
