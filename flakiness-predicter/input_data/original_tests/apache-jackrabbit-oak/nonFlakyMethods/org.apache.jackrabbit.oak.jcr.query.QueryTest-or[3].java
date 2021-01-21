@SuppressWarnings("deprecation") @Test public void or() throws RepositoryException {
  Session session=getAdminSession();
  Node hello=session.getRootNode().addNode("hello");
  hello.setProperty("x",1);
  Node world=hello.addNode("world");
  world.setProperty("x",2);
  session.save();
  QueryManager qm=session.getWorkspace().getQueryManager();
  Query q;
  q=qm.createQuery("select a.[jcr:path] from [nt:base] as a " + "inner join [nt:base] as b " + "on ischildnode(a, b) "+ "where a.x = 1 or a.x = 2 or b.x = 3 or b.x = 4",Query.JCR_SQL2);
  assertEquals("/hello",getPaths(q));
  q=qm.createQuery("//hello[@x=1]/*[@x=2]",Query.XPATH);
  assertEquals("/hello/world",getPaths(q));
}
