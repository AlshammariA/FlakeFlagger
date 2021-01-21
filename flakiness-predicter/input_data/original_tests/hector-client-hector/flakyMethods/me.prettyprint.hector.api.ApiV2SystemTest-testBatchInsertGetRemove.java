@Test public void testBatchInsertGetRemove(){
  String cf="Standard1";
  Mutator<String> m=createMutator(ko,se);
  for (int i=0; i < 5; i++) {
    m.addInsertion("testInsertGetRemove" + i,cf,createColumn("testInsertGetRemove","testInsertGetRemove_value_" + i,se,se));
  }
  m.execute();
  ColumnQuery<String,String,String> q=createColumnQuery(ko,se,se,se);
  q.setName("testInsertGetRemove").setColumnFamily(cf);
  for (int i=0; i < 5; i++) {
    QueryResult<HColumn<String,String>> r=q.setKey("testInsertGetRemove" + i).execute();
    assertNotNull(r);
    HColumn<String,String> c=r.get();
    assertNotNull(c);
    String value=c.getValue();
    assertEquals("testInsertGetRemove_value_" + i,value);
  }
  m=createMutator(ko,se);
  for (int i=0; i < 5; i++) {
    m.addDeletion("testInsertGetRemove" + i,cf,"testInsertGetRemove",se);
  }
  m.execute();
  ColumnQuery<String,String,String> q2=createColumnQuery(ko,se,se,se);
  q2.setName("testInsertGetRemove").setColumnFamily(cf);
  for (int i=0; i < 5; i++) {
    QueryResult<HColumn<String,String>> r=q2.setKey("testInsertGetRemove" + i).execute();
    assertNotNull(r);
    assertNull("Value should have been deleted",r.get());
  }
}
