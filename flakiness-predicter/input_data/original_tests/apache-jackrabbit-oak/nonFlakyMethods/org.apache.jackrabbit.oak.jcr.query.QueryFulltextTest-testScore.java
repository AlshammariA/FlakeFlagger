public void testScore() throws Exception {
  Session session=superuser;
  QueryManager qm=session.getWorkspace().getQueryManager();
  Node n1=testRootNode.addNode("node1");
  n1.setProperty("text","hello hello hello");
  Node n2=testRootNode.addNode("node2");
  n2.setProperty("text","hello");
  session.save();
  String xpath="/jcr:root//*[jcr:contains(@text, 'hello')] order by jcr:score()";
  Query q=qm.createQuery(xpath,"xpath");
  String result=getResult(q.execute(),"jcr:score");
  result=result.replaceAll("[0-9\\.]+","n");
  assertEquals("n, n",result);
}
