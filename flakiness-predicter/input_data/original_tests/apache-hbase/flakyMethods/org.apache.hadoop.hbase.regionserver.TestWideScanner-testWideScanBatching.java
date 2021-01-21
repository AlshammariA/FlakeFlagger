public void testWideScanBatching() throws IOException {
  try {
    this.r=createNewHRegion(REGION_INFO.getTableDesc(),null,null);
    int inserted=addWideContent(this.r,HConstants.CATALOG_FAMILY);
    List<KeyValue> results=new ArrayList<KeyValue>();
    Scan scan=new Scan();
    scan.addFamily(HConstants.CATALOG_FAMILY);
    scan.setBatch(BATCH);
    InternalScanner s=r.getScanner(scan);
    int total=0;
    int i=0;
    boolean more;
    do {
      more=s.next(results);
      i++;
      LOG.info("iteration #" + i + ", results.size="+ results.size());
      assertTrue(results.size() <= BATCH);
      total+=results.size();
      if (results.size() > 0) {
        byte[] row=results.get(0).getRow();
        for (        KeyValue kv : results) {
          assertTrue(Bytes.equals(row,kv.getRow()));
        }
      }
      results.clear();
    }
 while (more);
    LOG.info("inserted " + inserted + ", scanned "+ total);
    assertTrue(total == inserted);
    s.close();
  }
  finally {
    this.r.close();
    this.r.getLog().closeAndDelete();
    shutdownDfs(this.cluster);
  }
}
