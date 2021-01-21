@Test public void testEqClauseMiss(){
  QueryResult<OrderedRows<String,String,Long>> result=new IndexedSlicesQuery<String,String,Long>(keyspace,se,se,le).addEqualsExpression("birthyear",5L).addGteExpression("birthmonth",4L).addLteExpression("birthmonth",6L).setColumnNames("birthyear").setColumnFamily(cf).setStartKey("").execute();
  assertEquals(0,result.get().getList().size());
}
