@Test public void skip() throws RepositoryException {
  Session session=getAdminSession();
  Node hello1=session.getRootNode().addNode("hello1");
  hello1.setProperty("id","1");
  hello1.setProperty("data","x");
  session.save();
  Node hello3=hello1.addNode("hello3");
  hello3.setProperty("id","3");
  hello3.setProperty("data","z");
  session.save();
  Node hello2=hello3.addNode("hello2");
  hello2.setProperty("id","2");
  hello2.setProperty("data","y");
  session.save();
  ValueFactory vf=session.getValueFactory();
  QueryManager qm=session.getWorkspace().getQueryManager();
  Query q=qm.createQuery("select id from [nt:base] where data >= $data order by id",Query.JCR_SQL2);
  q.bindValue("data",vf.createValue("x"));
  for (int i=-1; i < 5; i++) {
    QueryResult r=q.execute();
    RowIterator it=r.getRows();
    assertEquals(3,r.getRows().getSize());
    assertEquals(3,r.getNodes().getSize());
    Row row;
    try {
      it.skip(i);
      assertTrue(i >= 0 && i <= 3);
    }
 catch (    IllegalArgumentException e) {
      assertEquals(-1,i);
    }
catch (    NoSuchElementException e) {
      assertTrue(i >= 2);
    }
    if (i <= 0) {
      assertTrue(it.hasNext());
      row=it.nextRow();
      assertEquals("1",row.getValue("id").getString());
    }
    if (i <= 1) {
      assertTrue(it.hasNext());
      row=it.nextRow();
      assertEquals("2",row.getValue("id").getString());
    }
    if (i <= 2) {
      assertTrue(it.hasNext());
      row=it.nextRow();
      assertEquals("3",row.getValue("id").getString());
    }
    assertFalse(it.hasNext());
  }
}
