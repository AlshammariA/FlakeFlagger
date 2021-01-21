@Test public void fulltextOrWithinText() throws Exception {
  Session session=getAdminSession();
  QueryManager qm=session.getWorkspace().getQueryManager();
  Node testRootNode=session.getRootNode().addNode("testroot");
  Node n1=testRootNode.addNode("node1");
  n1.setProperty("text","hello");
  Node n2=testRootNode.addNode("node2");
  n2.setProperty("text","hallo");
  Node n3=testRootNode.addNode("node3");
  n3.setProperty("text","hello hallo");
  session.save();
  String sql2="select [jcr:path] as [path] from [nt:base] " + "where contains([text], 'hello OR hallo') order by [jcr:path]";
  Query q;
  q=qm.createQuery("explain " + sql2,Query.JCR_SQL2);
  assertEquals("[nt:base] as [nt:base] /* traverse \"*\" " + "where contains([nt:base].[text], cast('hello OR hallo' as string)) */",getResult(q.execute(),"plan"));
  q=qm.createQuery(sql2,Query.JCR_SQL2);
  assertEquals("/testroot/node1, /testroot/node2, /testroot/node3",getResult(q.execute(),"path"));
  sql2="select [jcr:path] as [path] from [nt:base] " + "where contains([text], 'hello or hallo') order by [jcr:path]";
  q=qm.createQuery(sql2,Query.JCR_SQL2);
  assertEquals("",getResult(q.execute(),"path"));
}
