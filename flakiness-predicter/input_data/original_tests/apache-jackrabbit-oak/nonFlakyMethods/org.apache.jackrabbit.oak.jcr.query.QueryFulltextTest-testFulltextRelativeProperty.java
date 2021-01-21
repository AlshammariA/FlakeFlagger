public void testFulltextRelativeProperty() throws Exception {
  Session session=superuser;
  QueryManager qm=session.getWorkspace().getQueryManager();
  Node n1=testRootNode.addNode("node1");
  n1.setProperty("text","hello");
  Node n2=testRootNode.addNode("node2");
  n2.setProperty("text","hallo");
  Node n3=testRootNode.addNode("node3");
  n3.setProperty("text","hello hallo");
  session.save();
  Query q;
  String sql2="select [jcr:path] as [path] from [nt:base] " + "where ISCHILDNODE([/testroot])" + " AND CONTAINS(text, 'hallo')";
  q=qm.createQuery(sql2,Query.JCR_SQL2);
  assertEquals("/testroot/node2, /testroot/node3",getResult(q.execute(),"path"));
  sql2="select [jcr:path] as [path] from [nt:base] " + "where contains([node1/text], 'hello') order by [jcr:path]";
  q=qm.createQuery(sql2,Query.JCR_SQL2);
  assertEquals("/testroot",getResult(q.execute(),"path"));
  sql2="select [jcr:path] as [path] from [nt:base] " + "where contains([node2/text], 'hello OR hallo') order by [jcr:path]";
  q=qm.createQuery(sql2,Query.JCR_SQL2);
  assertEquals("/testroot",getResult(q.execute(),"path"));
}
