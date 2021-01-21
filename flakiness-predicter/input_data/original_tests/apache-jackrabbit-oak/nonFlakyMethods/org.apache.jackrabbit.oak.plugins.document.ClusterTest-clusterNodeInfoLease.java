@Test public void clusterNodeInfoLease() throws InterruptedException {
  MemoryDocumentStore store=new MemoryDocumentStore();
  ClusterNodeInfo c1, c2;
  c1=ClusterNodeInfo.getInstance(store,"m1",null);
  assertEquals(1,c1.getId());
  c1.setLeaseTime(1);
  c1.renewLease();
  Thread.sleep(10);
  c2=ClusterNodeInfo.getInstance(store,"m1",null);
  assertEquals(1,c2.getId());
}
