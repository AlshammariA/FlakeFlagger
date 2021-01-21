@Test public void cacheConsistency() throws Exception {
  long maxAge=1;
  long delta=TimeUnit.MINUTES.toMillis(10);
  Set<String> names=Sets.newHashSet();
  NodeBuilder b1=store.getRoot().builder();
  for (int i=0; i < 10; i++) {
    String name="test-" + i;
    b1.child(name);
    names.add(name);
  }
  store.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  for (  ChildNodeEntry entry : store.getRoot().getChildNodeEntries()) {
    entry.getNodeState();
  }
  b1=store.getRoot().builder();
  b1.getChildNode("test-7").remove();
  names.remove("test-7");
  store.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  clock.waitUntil(clock.getTime() + TimeUnit.HOURS.toMillis(maxAge) + delta);
  VersionGCStats stats=gc.gc(maxAge,TimeUnit.HOURS);
  assertEquals(1,stats.deletedDocGCCount);
  Set<String> children=Sets.newHashSet();
  for (  ChildNodeEntry entry : store.getRoot().getChildNodeEntries()) {
    children.add(entry.getName());
  }
  assertEquals(names,children);
}
