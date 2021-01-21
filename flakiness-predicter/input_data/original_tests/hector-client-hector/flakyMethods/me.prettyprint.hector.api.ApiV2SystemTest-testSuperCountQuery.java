@Test public void testSuperCountQuery(){
  String cf="Super1";
  TestCleanupDescriptor cleanup=insertSuperColumns(cf,1,"testSuperCountQuery",11,"testSuperCountQueryColumn");
  SuperCountQuery<String,String> cq=createSuperCountQuery(ko,se,se);
  cq.setColumnFamily(cf).setKey("testSuperCountQuery0");
  cq.setRange("testSuperCountQueryColumn","testSuperCountQueryColumn999",100);
  QueryResult<Integer> r=cq.execute();
  assertNotNull(r);
  assertEquals(Integer.valueOf(11),r.get());
  deleteColumns(cleanup);
}
