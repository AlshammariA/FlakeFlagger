@Test public void testDisableBetweenSplit() throws IOException {
  HTableDescriptor htd=new HTableDescriptor(TABLENAME);
  htd.setMaxFileSize(1024);
  htd.setMemStoreFlushSize(1024);
  HColumnDescriptor hcd=new HColumnDescriptor(FAMILYNAME);
  htd.addFamily(hcd);
  TEST_UTIL.getHBaseAdmin().createTable(htd);
  HTable t=new HTable(TEST_UTIL.getConfiguration(),TABLENAME);
  HBase2515Listener list=new HBase2515Listener(TEST_UTIL.getHBaseAdmin());
  MiniHBaseCluster cluster=TEST_UTIL.getHBaseCluster();
  HMaster m=cluster.getMaster();
  m.getRegionServerOperationQueue().registerRegionServerOperationListener(list);
  try {
    TEST_UTIL.loadTable(t,FAMILYNAME);
  }
 catch (  IOException ex) {
    LOG.info("Expected",ex);
  }
  assertEquals(0,cluster.getMaster().getClusterStatus().getRegionsInTransition().size());
}
