public void testGet() throws IOException {
  Get get=new Get(ROW_1);
  Result result=remoteTable.get(get);
  byte[] value1=result.getValue(COLUMN_1,QUALIFIER_1);
  byte[] value2=result.getValue(COLUMN_2,QUALIFIER_2);
  assertNotNull(value1);
  assertTrue(Bytes.equals(VALUE_1,value1));
  assertNull(value2);
  get=new Get(ROW_1);
  get.addFamily(COLUMN_3);
  result=remoteTable.get(get);
  value1=result.getValue(COLUMN_1,QUALIFIER_1);
  value2=result.getValue(COLUMN_2,QUALIFIER_2);
  assertNull(value1);
  assertNull(value2);
  get=new Get(ROW_1);
  get.addColumn(COLUMN_1,QUALIFIER_1);
  get.addColumn(COLUMN_2,QUALIFIER_2);
  result=remoteTable.get(get);
  value1=result.getValue(COLUMN_1,QUALIFIER_1);
  value2=result.getValue(COLUMN_2,QUALIFIER_2);
  assertNotNull(value1);
  assertTrue(Bytes.equals(VALUE_1,value1));
  assertNull(value2);
  get=new Get(ROW_2);
  result=remoteTable.get(get);
  value1=result.getValue(COLUMN_1,QUALIFIER_1);
  value2=result.getValue(COLUMN_2,QUALIFIER_2);
  assertNotNull(value1);
  assertTrue(Bytes.equals(VALUE_2,value1));
  assertNotNull(value2);
  assertTrue(Bytes.equals(VALUE_2,value2));
  get=new Get(ROW_2);
  get.addFamily(COLUMN_1);
  result=remoteTable.get(get);
  value1=result.getValue(COLUMN_1,QUALIFIER_1);
  value2=result.getValue(COLUMN_2,QUALIFIER_2);
  assertNotNull(value1);
  assertTrue(Bytes.equals(VALUE_2,value1));
  assertNull(value2);
  get=new Get(ROW_2);
  get.addColumn(COLUMN_1,QUALIFIER_1);
  get.addColumn(COLUMN_2,QUALIFIER_2);
  result=remoteTable.get(get);
  value1=result.getValue(COLUMN_1,QUALIFIER_1);
  value2=result.getValue(COLUMN_2,QUALIFIER_2);
  assertNotNull(value1);
  assertTrue(Bytes.equals(VALUE_2,value1));
  assertNotNull(value2);
  assertTrue(Bytes.equals(VALUE_2,value2));
  get=new Get(ROW_2);
  get.addFamily(COLUMN_1);
  get.addFamily(COLUMN_2);
  get.setTimeStamp(TS_1);
  result=remoteTable.get(get);
  value1=result.getValue(COLUMN_1,QUALIFIER_1);
  value2=result.getValue(COLUMN_2,QUALIFIER_2);
  assertNotNull(value1);
  assertTrue(Bytes.equals(VALUE_1,value1));
  assertNull(value2);
  get=new Get(ROW_2);
  get.addFamily(COLUMN_1);
  get.addFamily(COLUMN_2);
  get.setTimeRange(0,TS_1 + 1);
  result=remoteTable.get(get);
  value1=result.getValue(COLUMN_1,QUALIFIER_1);
  value2=result.getValue(COLUMN_2,QUALIFIER_2);
  assertNotNull(value1);
  assertTrue(Bytes.equals(VALUE_1,value1));
  assertNull(value2);
  get=new Get(ROW_2);
  get.addFamily(COLUMN_1);
  get.setMaxVersions(2);
  result=remoteTable.get(get);
  int count=0;
  for (  KeyValue kv : result.list()) {
    if (Bytes.equals(COLUMN_1,kv.getFamily()) && TS_1 == kv.getTimestamp()) {
      assertTrue(Bytes.equals(VALUE_1,kv.getValue()));
      count++;
    }
    if (Bytes.equals(COLUMN_1,kv.getFamily()) && TS_2 == kv.getTimestamp()) {
      assertTrue(Bytes.equals(VALUE_2,kv.getValue()));
      count++;
    }
  }
  assertEquals(2,count);
}
