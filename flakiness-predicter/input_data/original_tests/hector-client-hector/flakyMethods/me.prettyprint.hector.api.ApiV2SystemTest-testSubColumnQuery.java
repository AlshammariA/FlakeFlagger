@Test public void testSubColumnQuery(){
  String cf="Super1";
  TestCleanupDescriptor cleanup=insertSuperColumns(cf,1,"testSubColumnQuery",1,"testSubColumnQuerySuperColumn");
  SubColumnQuery<String,String,String,String> q=createSubColumnQuery(ko,se,se,se,se);
  q.setSuperColumn("testSubColumnQuerySuperColumn0").setColumn("c000").setColumnFamily(cf);
  QueryResult<HColumn<String,String>> r=q.setKey("testSubColumnQuery0").execute();
  assertNotNull(r);
  HColumn<String,String> c=r.get();
  assertNotNull(c);
  String value=c.getValue();
  assertEquals("v000",value);
  String name=c.getName();
  assertEquals("c000",name);
  q.setColumn("column doesn't exist");
  r=q.execute();
  assertNotNull(r);
  c=r.get();
  assertNull(c);
  deleteColumns(cleanup);
}
