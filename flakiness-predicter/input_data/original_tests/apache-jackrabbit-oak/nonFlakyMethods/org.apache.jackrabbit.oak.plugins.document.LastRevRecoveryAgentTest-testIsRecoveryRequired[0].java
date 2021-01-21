@Test public void testIsRecoveryRequired() throws Exception {
  NodeBuilder b1=ds1.getRoot().builder();
  b1.child("x").child("y");
  ds1.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  ds1.runBackgroundOperations();
  ds2.runBackgroundOperations();
  NodeBuilder b2=ds2.getRoot().builder();
  b2.child("x").child("y").child("z").setProperty("foo","bar");
  ds2.merge(b2,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  NodeDocument z1=getDocument(ds1,"/x/y/z");
  Revision zlastRev2=z1.getLastRev().get(c2Id);
  long leaseTime=ds1.getClusterInfo().getLeaseTime();
  ds1.runBackgroundOperations();
  clock.waitUntil(clock.getTime() + leaseTime + 10);
  ds1.getClusterInfo().renewLease();
  assertTrue(ds1.getLastRevRecoveryAgent().isRecoveryNeeded());
  List<Integer> cids=ds1.getLastRevRecoveryAgent().getRecoveryCandidateNodes();
  assertEquals(1,cids.size());
  assertEquals(c2Id,cids.get(0).intValue());
  ds1.getLastRevRecoveryAgent().recover(cids.get(0));
  assertEquals(zlastRev2,getDocument(ds1,"/x/y").getLastRev().get(c2Id));
  assertEquals(zlastRev2,getDocument(ds1,"/x").getLastRev().get(c2Id));
  assertEquals(zlastRev2,getDocument(ds1,"/").getLastRev().get(c2Id));
}
