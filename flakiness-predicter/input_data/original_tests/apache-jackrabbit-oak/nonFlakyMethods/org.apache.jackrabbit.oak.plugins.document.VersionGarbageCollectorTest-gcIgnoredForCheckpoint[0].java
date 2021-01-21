@Test public void gcIgnoredForCheckpoint() throws Exception {
  long expiryTime=100, maxAge=20;
  Revision cp=Revision.fromString(store.checkpoint(expiryTime));
  clock.waitUntil(cp.getTimestamp() + expiryTime - maxAge);
  VersionGCStats stats=gc.gc(maxAge,TimeUnit.MILLISECONDS);
  assertTrue(stats.ignoredGCDueToCheckPoint);
  clock.waitUntil(clock.getTime() + expiryTime + 1);
  stats=gc.gc(maxAge,TimeUnit.MILLISECONDS);
  assertFalse("GC should be performed",stats.ignoredGCDueToCheckPoint);
}
