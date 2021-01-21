@Test public void testOak1128() throws RepositoryException {
  Session session=createAdminSession();
  Node p=session.getRootNode().addNode("etc");
  p.addNode("p1");
  Node r=p.addNode("p2").addNode("r","nt:unstructured");
  r.setProperty("nt:resourceType","test");
  session.save();
  Query q=session.getWorkspace().getQueryManager().createQuery("/jcr:root/etc//*[" + "(@jcr:primaryType = 'a'  or @jcr:primaryType = 'b') " + "or @nt:resourceType = 'test']","xpath");
  QueryResult qr=q.execute();
  NodeIterator ni=qr.getNodes();
  Node n=ni.nextNode();
  assertEquals("/etc/p2/r",n.getPath());
}
