@Test public void testInsertGetRemove(){
  IndexedSlicesQuery<String,String,Long> indexedSlicesQuery=new IndexedSlicesQuery<String,String,Long>(keyspace,se,se,le);
  indexedSlicesQuery.addEqualsExpression("birthyear",1975L);
  indexedSlicesQuery.setReturnKeysOnly();
  indexedSlicesQuery.setColumnFamily(cf);
  indexedSlicesQuery.setStartKey("");
  QueryResult<OrderedRows<String,String,Long>> result=indexedSlicesQuery.execute();
  assertEquals(4,result.get().getList().size());
}
