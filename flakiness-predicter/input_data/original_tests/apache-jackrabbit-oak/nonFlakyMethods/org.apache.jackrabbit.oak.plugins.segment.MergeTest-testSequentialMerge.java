@Test public void testSequentialMerge() throws CommitFailedException {
  NodeStore store=new SegmentNodeStore(new MemoryStore());
  assertFalse(store.getRoot().hasProperty("foo"));
  assertFalse(store.getRoot().hasProperty("bar"));
  NodeBuilder a=store.getRoot().builder();
  a.setProperty("foo","abc");
  store.merge(a,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  assertTrue(store.getRoot().hasProperty("foo"));
  assertFalse(store.getRoot().hasProperty("bar"));
  NodeBuilder b=store.getRoot().builder();
  b.setProperty("bar","xyz");
  store.merge(b,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  assertTrue(store.getRoot().hasProperty("foo"));
  assertTrue(store.getRoot().hasProperty("bar"));
}
