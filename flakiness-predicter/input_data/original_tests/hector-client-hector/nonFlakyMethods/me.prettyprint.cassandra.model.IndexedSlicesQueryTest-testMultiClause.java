@Test public void testMultiClause(){
  QueryResult<OrderedRows<String,String,Long>> result=new IndexedSlicesQuery<String,String,Long>(keyspace,se,se,le).addEqualsExpression("birthyear",1975L).addGteExpression("birthmonth",4L).addLteExpression("birthmonth",6L).setColumnNames("birthyear").setColumnFamily(cf).setStartKey("").execute();
  assertEquals(3,result.get().getList().size());
}
