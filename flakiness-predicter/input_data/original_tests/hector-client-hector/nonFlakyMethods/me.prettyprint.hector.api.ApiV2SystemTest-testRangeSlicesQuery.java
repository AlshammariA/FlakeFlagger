@Test public void testRangeSlicesQuery(){
  String cf="Standard1";
  TestCleanupDescriptor cleanup=insertColumns(cf,4,"testRangeSlicesQuery",3,"testRangeSlicesQueryColumn");
  RangeSlicesQuery<String,String,String> q=createRangeSlicesQuery(ko,se,se,se);
  q.setColumnFamily(cf);
  q.setKeys("testRangeSlicesQuery1","testRangeSlicesQuery3");
  q.setColumnNames("testRangeSlicesQueryColumn1","testRangeSlicesQueryColumn2");
  QueryResult<OrderedRows<String,String,String>> r=q.execute();
  assertNotNull(r);
  OrderedRows<String,String,String> rows=r.get();
  assertNotNull(rows);
  assertEquals(3,rows.getCount());
  Row<String,String,String> row=rows.getList().get(0);
  assertNotNull(row);
  assertEquals("testRangeSlicesQuery1",row.getKey());
  ColumnSlice<String,String> slice=row.getColumnSlice();
  assertNotNull(slice);
  assertEquals("value11",slice.getColumnByName("testRangeSlicesQueryColumn1").getValue());
  assertEquals("value12",slice.getColumnByName("testRangeSlicesQueryColumn2").getValue());
  assertNull(slice.getColumnByName("testRangeSlicesQueryColumn3"));
  List<HColumn<String,String>> columns=slice.getColumns();
  assertNotNull(columns);
  assertEquals(2,columns.size());
  q.setKeys("testRangeSlicesQuery1","testRangeSlicesQuery5");
  q.setRange("testRangeSlicesQueryColumn1","testRangeSlicesQueryColumn3",false,100);
  r=q.execute();
  assertNotNull(r);
  rows=r.get();
  assertEquals(3,rows.getCount());
  for (  Row<String,String,String> row2 : rows) {
    assertNotNull(row2);
    slice=row2.getColumnSlice();
    assertNotNull(slice);
    assertEquals(2,slice.getColumns().size());
    for (    HColumn<String,String> column : slice.getColumns()) {
      if (!column.getName().equals("testRangeSlicesQueryColumn1") && !column.getName().equals("testRangeSlicesQueryColumn2")) {
        fail("A columns with unexpected column name returned: " + column.getName());
      }
    }
  }
  deleteColumns(cleanup);
}
