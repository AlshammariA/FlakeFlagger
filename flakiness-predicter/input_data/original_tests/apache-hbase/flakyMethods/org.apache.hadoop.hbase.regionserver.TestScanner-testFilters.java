public void testFilters() throws IOException {
  try {
    this.r=createNewHRegion(REGION_INFO.getTableDesc(),null,null);
    addContent(this.r,HConstants.CATALOG_FAMILY);
    byte[] prefix=Bytes.toBytes("ab");
    Filter newFilter=new PrefixFilter(prefix);
    Scan scan=new Scan();
    scan.setFilter(newFilter);
    rowPrefixFilter(scan);
    byte[] stopRow=Bytes.toBytes("bbc");
    newFilter=new WhileMatchFilter(new InclusiveStopFilter(stopRow));
    scan=new Scan();
    scan.setFilter(newFilter);
    rowInclusiveStopFilter(scan,stopRow);
  }
  finally {
    this.r.close();
    this.r.getLog().closeAndDelete();
    shutdownDfs(this.cluster);
  }
}
