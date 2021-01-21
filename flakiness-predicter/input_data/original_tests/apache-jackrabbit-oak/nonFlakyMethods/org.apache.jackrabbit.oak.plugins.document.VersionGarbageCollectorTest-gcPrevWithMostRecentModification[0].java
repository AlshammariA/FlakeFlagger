@Test public void gcPrevWithMostRecentModification() throws Exception {
  long maxAge=1;
  long delta=TimeUnit.MINUTES.toMillis(10);
  for (int i=0; i < NUM_REVS_THRESHOLD + 1; i++) {
    NodeBuilder builder=store.getRoot().builder();
    builder.child("foo").setProperty("prop","v" + i);
    builder.child("bar").setProperty("prop","v" + i);
    store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  }
  store.runBackgroundOperations();
  clock.waitUntil(clock.getTime() + TimeUnit.HOURS.toMillis(maxAge) + delta);
  VersionGCStats stats=gc.gc(maxAge,TimeUnit.HOURS);
  NodeDocument doc=getDoc("/foo");
  assertNotNull(doc);
  DocumentNodeState state=doc.getNodeAtRevision(store,store.getHeadRevision(),null);
  assertNotNull(state);
}
