@Test public void liveNode() throws RepositoryException {
  Session session=getAdminSession();
  Node n1=session.getNode(TEST_PATH);
  Node n2=session.getNode(TEST_PATH);
  assertTrue(n1.isSame(n2));
  Node c1=n1.addNode("c1");
  n1.setProperty("p1","v1");
  c1.setProperty("pc1","vc1");
  Node c2=n2.addNode("c2");
  n2.setProperty("p2","v2");
  c2.setProperty("pc2","vc2");
  assertTrue(c1.isSame(n2.getNode("c1")));
  assertTrue(c2.isSame(n1.getNode("c2")));
  assertTrue(n1.hasNode("c1"));
  assertTrue(n1.hasNode("c2"));
  assertTrue(n1.hasProperty("p1"));
  assertTrue(n1.hasProperty("p2"));
  assertTrue(c1.hasProperty("pc1"));
  assertFalse(c1.hasProperty("pc2"));
  assertTrue(n2.hasNode("c1"));
  assertTrue(n2.hasNode("c2"));
  assertTrue(n2.hasProperty("p1"));
  assertTrue(n2.hasProperty("p2"));
  assertFalse(c2.hasProperty("pc1"));
  assertTrue(c2.hasProperty("pc2"));
}
