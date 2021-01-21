@SuppressWarnings("deprecation") @Test public void encodedPath() throws RepositoryException {
  Session session=getAdminSession();
  session.getRootNode().addNode("hello").addNode("world");
  session.save();
  QueryManager qm=session.getWorkspace().getQueryManager();
  Query q;
  q=qm.createQuery("/jcr:root/hel_x006c_o/*",Query.XPATH);
  assertEquals("/hello/world",getPaths(q));
  q=qm.createQuery("//hel_x006c_o",Query.XPATH);
  assertEquals("/hello",getPaths(q));
  q=qm.createQuery("//element(hel_x006c_o, nt:base)",Query.XPATH);
  assertEquals("/hello",getPaths(q));
}
