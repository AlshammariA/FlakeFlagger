@Test public void limit() throws RepositoryException {
  Session session=getAdminSession();
  Node hello1=session.getRootNode().addNode("hello1");
  hello1.setProperty("id","1");
  hello1.setProperty("data","x");
  session.save();
  Node hello3=session.getRootNode().addNode("hello3");
  hello3.setProperty("id","3");
  hello3.setProperty("data","z");
  session.save();
  Node hello2=session.getRootNode().addNode("hello2");
  hello2.setProperty("id","2");
  hello2.setProperty("data","y");
  session.save();
  ValueFactory vf=session.getValueFactory();
  QueryManager qm=session.getWorkspace().getQueryManager();
  Query q=qm.createQuery("select id from [nt:base] where data >= $data order by id",Query.JCR_SQL2);
  q.bindValue("data",vf.createValue("x"));
  for (int limit=0; limit < 5; limit++) {
    q.setLimit(limit);
    for (int offset=0; offset < 3; offset++) {
      q.setOffset(offset);
      QueryResult r=q.execute();
      RowIterator it=r.getRows();
      int l=Math.min(Math.max(0,3 - offset),limit);
      assertEquals(l,r.getRows().getSize());
      assertEquals(l,r.getNodes().getSize());
      Row row;
      for (int x=offset + 1, i=0; i < limit && x < 4; i++, x++) {
        assertTrue(it.hasNext());
        row=it.nextRow();
        assertEquals("" + x,row.getValue("id").getString());
      }
      assertFalse(it.hasNext());
    }
  }
}
