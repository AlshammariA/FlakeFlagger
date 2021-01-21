@Test public void liveNodes() throws RepositoryException {
  Session session=getAdminSession();
  Node n1=(Node)session.getItem(TEST_PATH);
  Node n2=(Node)session.getItem(TEST_PATH);
  Node c1=n1.addNode("c1");
  Node c2=n2.addNode("c2");
  assertTrue(n1.hasNode("c1"));
  assertTrue(n1.hasNode("c2"));
  assertTrue(n2.hasNode("c1"));
  assertTrue(n2.hasNode("c2"));
  c1.remove();
  assertFalse(n1.hasNode("c1"));
  assertTrue(n1.hasNode("c2"));
  assertFalse(n2.hasNode("c1"));
  assertTrue(n2.hasNode("c2"));
  c2.remove();
  assertFalse(n1.hasNode("c1"));
  assertFalse(n1.hasNode("c2"));
  assertFalse(n2.hasNode("c1"));
  assertFalse(n2.hasNode("c2"));
}
