/** 
 * OAK-1093
 */
@Test public void getValuesOnMvp() throws RepositoryException {
  Session session=getAdminSession();
  Node hello=session.getRootNode().addNode("hello");
  hello.setProperty("id","1");
  hello.setProperty("properties",new String[]{"p1","p2"});
  session.save();
  QueryManager qm=session.getWorkspace().getQueryManager();
  Query q=qm.createQuery("select properties from [nt:base] where id = 1",Query.JCR_SQL2);
  QueryResult r=q.execute();
  RowIterator it=r.getRows();
  assertTrue(it.hasNext());
  Row row=it.nextRow();
  assertEquals("p1 p2",row.getValues()[0].getString());
}
