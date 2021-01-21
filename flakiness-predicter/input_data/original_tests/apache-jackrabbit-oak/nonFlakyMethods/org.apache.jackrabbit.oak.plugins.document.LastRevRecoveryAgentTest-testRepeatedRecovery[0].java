@Test public void testRepeatedRecovery() throws Exception {
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
  ds1.getLastRevRecoveryAgent().performRecoveryIfNeeded();
  assertFalse(ds1.getLastRevRecoveryAgent().isRecoveryNeeded());
}
