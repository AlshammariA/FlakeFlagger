@Test public void testCheckpointPurge() throws Exception {
  long expiryTime=1000;
  Revision r1=Revision.fromString(store.checkpoint(expiryTime));
  assertEquals(r1,store.getCheckpoints().getOldestRevisionToKeep());
  clock.waitUntil(clock.getTime() + expiryTime + 1);
  assertNull(store.getCheckpoints().getOldestRevisionToKeep());
}
