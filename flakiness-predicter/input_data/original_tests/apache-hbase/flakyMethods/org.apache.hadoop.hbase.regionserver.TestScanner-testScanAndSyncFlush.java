/** 
 * Tests to do a sync flush during the middle of a scan. This is testing the StoreScanner update readers code essentially.  This is not highly concurrent, since its all 1 thread. HBase-910.
 * @throws Exception
 */
public void testScanAndSyncFlush() throws Exception {
  this.r=createNewHRegion(REGION_INFO.getTableDesc(),null,null);
  HRegionIncommon hri=new HRegionIncommon(r);
  try {
    LOG.info("Added: " + addContent(hri,Bytes.toString(HConstants.CATALOG_FAMILY),Bytes.toString(HConstants.REGIONINFO_QUALIFIER)));
    int count=count(hri,-1,false);
    assertEquals(count,count(hri,100,false));
  }
 catch (  Exception e) {
    LOG.error("Failed",e);
    throw e;
  }
 finally {
    this.r.close();
    this.r.getLog().closeAndDelete();
    shutdownDfs(cluster);
  }
}
