@Test public void testMultigetSliceQuery(){
  String cf="Standard1";
  TestCleanupDescriptor cleanup=insertColumns(cf,4,"testMultigetSliceQuery",3,"testMultigetSliceQueryColumn");
  MultigetSliceQuery<String,String,String> q=createMultigetSliceQuery(ko,se,se,se);
  q.setColumnFamily(cf);
  q.setKeys("testMultigetSliceQuery1","testMultigetSliceQuery2");
  q.setColumnNames("testMultigetSliceQueryColumn1","testMultigetSliceQueryColumn2");
  QueryResult<Rows<String,String,String>> r=q.execute();
  assertNotNull(r);
  Rows<String,String,String> rows=r.get();
  assertNotNull(rows);
  assertEquals(2,rows.getCount());
  Row<String,String,String> row=rows.getByKey("testMultigetSliceQuery1");
  assertNotNull(row);
  assertEquals("testMultigetSliceQuery1",row.getKey());
  ColumnSlice<String,String> slice=row.getColumnSlice();
  assertNotNull(slice);
  assertEquals("value11",slice.getColumnByName("testMultigetSliceQueryColumn1").getValue());
  assertEquals("value12",slice.getColumnByName("testMultigetSliceQueryColumn2").getValue());
  assertNull(slice.getColumnByName("testMultigetSliceQueryColumn3"));
  List<HColumn<String,String>> columns=slice.getColumns();
  assertNotNull(columns);
  assertEquals(2,columns.size());
  q=createMultigetSliceQuery(ko,se,se,se);
  q.setColumnFamily(cf);
  q.setKeys("testMultigetSliceQuery3");
  q.setRange("testMultigetSliceQueryColumn1","testMultigetSliceQueryColumn3",false,100);
  r=q.execute();
  assertNotNull(r);
  rows=r.get();
  assertEquals(1,rows.getCount());
  for (  Row<String,String,String> row2 : rows) {
    assertNotNull(row2);
    slice=row2.getColumnSlice();
    assertNotNull(slice);
    for (    HColumn<String,String> column : slice.getColumns()) {
      if (!column.getName().equals("testMultigetSliceQueryColumn1") && !column.getName().equals("testMultigetSliceQueryColumn2") && !column.getName().equals("testMultigetSliceQueryColumn3")) {
        fail("A columns with unexpected column name returned: " + column.getName());
      }
    }
  }
  deleteColumns(cleanup);
}
