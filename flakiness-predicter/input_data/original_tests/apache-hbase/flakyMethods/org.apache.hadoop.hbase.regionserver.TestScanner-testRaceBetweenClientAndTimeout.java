/** 
 * Test that closing a scanner while a client is using it doesn't throw NPEs but instead a UnknownScannerException. HBASE-2503
 * @throws Exception
 */
public void testRaceBetweenClientAndTimeout() throws Exception {
  try {
    this.r=createNewHRegion(REGION_INFO.getTableDesc(),null,null);
    addContent(this.r,HConstants.CATALOG_FAMILY);
    Scan scan=new Scan();
    InternalScanner s=r.getScanner(scan);
    List<KeyValue> results=new ArrayList<KeyValue>();
    try {
      s.next(results);
      s.close();
      s.next(results);
      fail("We don't want anything more, we should be failing");
    }
 catch (    UnknownScannerException ex) {
      return;
    }
  }
  finally {
    this.r.close();
    this.r.getLog().closeAndDelete();
    shutdownDfs(this.cluster);
  }
}
