public void testScoreWithOr() throws Exception {
  Session session=superuser;
  QueryManager qm=session.getWorkspace().getQueryManager();
  Node n1=testRootNode.addNode("node1");
  n1.setProperty("text","hello");
  n1.setProperty("id","1");
  session.save();
  String xpath="/jcr:root//*[jcr:contains(@text, 'hello') or @id = '1']";
  Query q=qm.createQuery(xpath,"xpath");
  String result=getResult(q.execute(),"jcr:path");
  assertEquals("/testroot/node1",result);
}
