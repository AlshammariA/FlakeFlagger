/** 
 * Tests that logs are deleted
 * @throws Exception
 */
public void testLogRolling() throws Exception {
  this.tableName=getName();
  try {
    startAndWriteData();
    LOG.info("after writing there are " + log.getNumLogFiles() + " log files");
    List<HRegion> regions=new ArrayList<HRegion>(server.getOnlineRegions());
    for (    HRegion r : regions) {
      r.flushcache();
    }
    log.rollWriter();
    int count=log.getNumLogFiles();
    LOG.info("after flushing all regions and rolling logs there are " + log.getNumLogFiles() + " log files");
    assertTrue(("actual count: " + count),count <= 2);
  }
 catch (  Exception e) {
    LOG.fatal("unexpected exception",e);
    throw e;
  }
}
