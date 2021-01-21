@Test public void testKeysOnlyPredicate(){
  RangeSlicesQuery<String,String,Long> rangeSlicesQuery=HFactory.createRangeSlicesQuery(keyspace,se,se,le);
  QueryResult<OrderedRows<String,String,Long>> result=rangeSlicesQuery.setColumnFamily(cf).setKeys("","").setReturnKeysOnly().execute();
  OrderedRows<String,String,Long> orderedRows=result.get();
  Row<String,String,Long> row=orderedRows.iterator().next();
  assertNotNull(row.getKey());
  assertEquals(0,row.getColumnSlice().getColumns().size());
  result=rangeSlicesQuery.setColumnNames("birthyear","birthmonth").setRowCount(5).execute();
  orderedRows=result.get();
  row=orderedRows.iterator().next();
  assertNotNull(row.getKey());
  assertEquals(2,row.getColumnSlice().getColumns().size());
}
