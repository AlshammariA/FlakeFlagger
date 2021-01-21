@Test public void testCheckpointPurgeByCount() throws Exception {
  long expiryTime=TimeUnit.HOURS.toMillis(1);
  Revision r1=null;
  for (int i=0; i < Checkpoints.CLEANUP_INTERVAL; i++) {
    r1=Revision.fromString(store.checkpoint(expiryTime));
    store.setHeadRevision(Revision.newRevision(0));
  }
  assertEquals(r1,store.getCheckpoints().getOldestRevisionToKeep());
  assertEquals(Checkpoints.CLEANUP_INTERVAL,store.getCheckpoints().size());
  clock.waitUntil(clock.getTime() + expiryTime);
  store.checkpoint(expiryTime);
  assertEquals(1,store.getCheckpoints().size());
}
