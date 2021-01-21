@Test public void testMultigetSubSliceQuery(){
  String cf="Super1";
  TestCleanupDescriptor cleanup=insertSuperColumns(cf,3,"testMultigetSubSliceQuery",1,"testMultigetSubSliceQuery");
  MultigetSubSliceQuery<String,String,String,String> q=createMultigetSubSliceQuery(ko,se,se,se,se);
  q.setColumnFamily(cf);
  q.setSuperColumn("testMultigetSubSliceQuery0");
  q.setKeys("testMultigetSubSliceQuery0","testMultigetSubSliceQuery2");
  q.setColumnNames("c000","c110");
  QueryResult<Rows<String,String,String>> r=q.execute();
  assertNotNull(r);
  Rows<String,String,String> rows=r.get();
  assertNotNull(rows);
  assertEquals(2,rows.getCount());
  Row<String,String,String> row=rows.getByKey("testMultigetSubSliceQuery0");
  assertNotNull(row);
  assertEquals("testMultigetSubSliceQuery0",row.getKey());
  ColumnSlice<String,String> slice=row.getColumnSlice();
  assertNotNull(slice);
  assertEquals("v000",slice.getColumnByName("c000").getValue());
  assertEquals("v100",slice.getColumnByName("c110").getValue());
  List<HColumn<String,String>> columns=slice.getColumns();
  assertNotNull(columns);
  assertEquals(2,columns.size());
  q=createMultigetSubSliceQuery(ko,se,se,se,se);
  q.setColumnFamily(cf);
  q.setKeys("testMultigetSubSliceQuery0");
  q.setSuperColumn("testMultigetSubSliceQuery0");
  q.setRange("c000","c110",false,2);
  r=q.execute();
  assertNotNull(r);
  rows=r.get();
  assertEquals(1,rows.getCount());
  for (  Row<String,String,String> row2 : rows) {
    assertNotNull(row2);
    slice=row2.getColumnSlice();
    assertNotNull(slice);
    assertEquals(2,slice.getColumns().size());
    for (    HColumn<String,String> column : slice.getColumns()) {
      if (!column.getName().equals("c000") && !column.getName().equals("c110")) {
        fail("A columns with unexpected column name returned: " + column.getName());
      }
    }
  }
  deleteColumns(cleanup);
}
