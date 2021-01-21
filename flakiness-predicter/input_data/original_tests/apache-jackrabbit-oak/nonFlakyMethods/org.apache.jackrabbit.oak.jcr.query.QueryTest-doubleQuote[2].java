@Test public void doubleQuote() throws RepositoryException {
  Session session=getAdminSession();
  Node hello=session.getRootNode().addNode("hello");
  hello.setProperty("x",1);
  Node world=hello.addNode("world");
  world.setProperty("x",2);
  session.save();
  QueryManager qm=session.getWorkspace().getQueryManager();
  Query q;
  q=qm.createQuery("SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE(s,[/hello])",Query.JCR_SQL2);
  assertEquals("/hello/world",getPaths(q));
  q=qm.createQuery("SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE(s,\"/hello\")",Query.JCR_SQL2);
  assertEquals("/hello/world",getPaths(q));
  try {
    q=qm.createQuery("SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE(s,[\"/hello\"])",Query.JCR_SQL2);
    getPaths(q);
    fail();
  }
 catch (  InvalidQueryException e) {
  }
}
