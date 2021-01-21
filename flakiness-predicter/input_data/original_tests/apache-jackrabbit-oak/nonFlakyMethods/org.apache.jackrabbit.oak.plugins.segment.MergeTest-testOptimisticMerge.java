@Test public void testOptimisticMerge() throws CommitFailedException {
  NodeStore store=new SegmentNodeStore(new MemoryStore());
  NodeBuilder a=store.getRoot().builder();
  a.setProperty("foo","abc");
  NodeBuilder b=store.getRoot().builder();
  b.setProperty("bar","xyz");
  assertFalse(store.getRoot().hasProperty("foo"));
  assertFalse(store.getRoot().hasProperty("bar"));
  store.merge(a,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  assertTrue(store.getRoot().hasProperty("foo"));
  assertFalse(store.getRoot().hasProperty("bar"));
  store.merge(b,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  assertTrue(store.getRoot().hasProperty("foo"));
  assertTrue(store.getRoot().hasProperty("bar"));
}
