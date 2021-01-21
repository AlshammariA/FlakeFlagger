@Test public void testDisableAndEnableTable() throws IOException {
  final byte[] row=Bytes.toBytes("row");
  final byte[] qualifier=Bytes.toBytes("qualifier");
  final byte[] value=Bytes.toBytes("value");
  final byte[] table=Bytes.toBytes("testDisableAndEnableTable");
  HTable ht=TEST_UTIL.createTable(table,HConstants.CATALOG_FAMILY);
  Put put=new Put(row);
  put.add(HConstants.CATALOG_FAMILY,qualifier,value);
  ht.put(put);
  this.admin.disableTable(table);
  Get get=new Get(row);
  get.addColumn(HConstants.CATALOG_FAMILY,qualifier);
  boolean ok=false;
  try {
    ht.get(get);
  }
 catch (  RetriesExhaustedException e) {
    ok=true;
  }
  assertEquals(true,ok);
  this.admin.enableTable(table);
  try {
    ht.get(get);
  }
 catch (  RetriesExhaustedException e) {
    ok=false;
  }
  assertEquals(true,ok);
}
