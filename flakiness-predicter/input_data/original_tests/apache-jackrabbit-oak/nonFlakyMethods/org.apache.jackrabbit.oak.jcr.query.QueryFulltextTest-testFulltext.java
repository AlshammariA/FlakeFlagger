public void testFulltext() throws Exception {
  Session session=superuser;
  QueryManager qm=session.getWorkspace().getQueryManager();
  Node n1=testRootNode.addNode("node1");
  n1.setProperty("text","hello");
  Node n2=testRootNode.addNode("node2");
  n2.setProperty("text","hallo");
  Node n3=testRootNode.addNode("node3");
  n3.setProperty("text","hello hallo");
  session.save();
  String sql2="select [jcr:path] as [path] from [nt:base] " + "where contains([text], 'hello or hallo') order by [jcr:path]";
  Query q=qm.createQuery(sql2,Query.JCR_SQL2);
  assertEquals("",getResult(q.execute(),"path"));
}
