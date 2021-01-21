@Test public void date() throws Exception {
  Session session=getAdminSession();
  Node t1=session.getRootNode().addNode("t1");
  t1.setProperty("x","22.06.07");
  Node t2=session.getRootNode().addNode("t2");
  t2.setProperty("x","2007-06-22T01:02:03.000Z",PropertyType.DATE);
  session.save();
  String query="//*[x='a' or x='b']";
  QueryResult r=session.getWorkspace().getQueryManager().createQuery(query,"xpath").execute();
  NodeIterator it=r.getNodes();
  assertFalse(it.hasNext());
}
