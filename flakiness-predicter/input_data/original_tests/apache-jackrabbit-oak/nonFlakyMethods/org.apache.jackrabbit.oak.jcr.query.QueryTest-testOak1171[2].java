@Test public void testOak1171() throws RepositoryException {
  Session session=createAdminSession();
  Node p=session.getRootNode().addNode("etc");
  p.addNode("p1").setProperty("title","test");
  p.addNode("p2").setProperty("title",1);
  session.save();
  Query q=session.getWorkspace().getQueryManager().createQuery("//*[@title = 'test']","xpath");
  QueryResult qr=q.execute();
  NodeIterator ni=qr.getNodes();
  assertTrue(ni.hasNext());
  Node n=ni.nextNode();
  assertEquals("/etc/p1",n.getPath());
  assertFalse(ni.hasNext());
}
