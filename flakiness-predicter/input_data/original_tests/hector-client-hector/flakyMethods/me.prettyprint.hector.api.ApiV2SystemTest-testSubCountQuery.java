@Test public void testSubCountQuery(){
  String cf="Super1";
  TestCleanupDescriptor cleanup=insertSuperColumns(cf,1,"testSubCountQuery",1,"testSubCountQueryColumn");
  SubCountQuery<String,String,String> cq=createSubCountQuery(ko,se,se,se);
  cq.setRange("c0","c3",100);
  QueryResult<Integer> r=cq.setColumnFamily(cf).setKey("testSubCountQuery0").setSuperColumn("testSubCountQueryColumn0").execute();
  assertNotNull(r);
  assertEquals(Integer.valueOf(2),r.get());
  deleteColumns(cleanup);
}
