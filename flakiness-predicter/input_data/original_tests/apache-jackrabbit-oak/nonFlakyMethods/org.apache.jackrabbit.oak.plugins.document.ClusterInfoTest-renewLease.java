@Test public void renewLease() throws InterruptedException {
  MemoryDocumentStore mem=new MemoryDocumentStore();
  Clock clock=new Clock.Virtual();
  clock.waitUntil(System.currentTimeMillis());
  ClusterNodeInfo.setClock(clock);
  DocumentNodeStore ns=new DocumentMK.Builder().setDocumentStore(mem).setAsyncDelay(0).getNodeStore();
  ClusterNodeInfo info=ns.getClusterInfo();
  assertNotNull(info);
  long leaseEnd=getLeaseEndTime(ns);
  clock.waitUntil(clock.getTime() + (ns.getClusterInfo().getLeaseTime() / 2) - 1000);
  ns.renewClusterIdLease();
  assertEquals(leaseEnd,getLeaseEndTime(ns));
  clock.waitUntil(clock.getTime() + 2000);
  ns.renewClusterIdLease();
  assertTrue(getLeaseEndTime(ns) > leaseEnd);
  ns.dispose();
}
