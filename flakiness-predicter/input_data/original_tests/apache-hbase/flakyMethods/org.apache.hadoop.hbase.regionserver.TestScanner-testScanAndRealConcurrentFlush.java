/** 
 * Tests to do a concurrent flush (using a 2nd thread) while scanning.  This tests both the StoreScanner update readers and the transition from memstore -> snapshot -> store file.
 * @throws Exception
 */
public void testScanAndRealConcurrentFlush() throws Exception {
  this.r=createNewHRegion(REGION_INFO.getTableDesc(),null,null);
  HRegionIncommon hri=new HRegionIncommon(r);
  try {
    LOG.info("Added: " + addContent(hri,Bytes.toString(HConstants.CATALOG_FAMILY),Bytes.toString(HConstants.REGIONINFO_QUALIFIER)));
    int count=count(hri,-1,false);
    assertEquals(count,count(hri,100,true));
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
