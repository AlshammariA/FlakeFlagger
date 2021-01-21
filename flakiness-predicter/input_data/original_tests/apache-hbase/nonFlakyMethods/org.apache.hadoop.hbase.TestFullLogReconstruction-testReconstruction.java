/** 
 * Test the whole reconstruction loop. Build a table with regions aaa to zzz and load every one of them multiple times with the same date and do a flush at some point. Kill one of the region servers and scan the table. We should see all the rows.
 * @throws Exception
 */
@Test public void testReconstruction() throws Exception {
  TEST_UTIL.createTable(TABLE_NAME,FAMILY);
  HTable table=new HTable(TABLE_NAME);
  TEST_UTIL.createMultiRegions(table,Bytes.toBytes("family"));
  int initialCount=TEST_UTIL.loadTable(table,FAMILY);
  Scan scan=new Scan();
  ResultScanner results=table.getScanner(scan);
  int count=0;
  for (  Result res : results) {
    count++;
  }
  results.close();
  assertEquals(initialCount,count);
  for (int i=0; i < 4; i++) {
    TEST_UTIL.loadTable(table,FAMILY);
    if (i == 2) {
      TEST_UTIL.flush();
    }
  }
  TEST_UTIL.expireRegionServerSession(0);
  scan=new Scan();
  results=table.getScanner(scan);
  int newCount=0;
  for (  Result res : results) {
    newCount++;
  }
  assertEquals(count,newCount);
}
