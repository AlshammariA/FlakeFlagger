@Test public void checkpointRemove() throws Exception {
  long et1=1000, et2=et1 + 1000;
  String cp1=store.checkpoint(et1);
  Revision r1=Revision.fromString(cp1);
  NodeBuilder b2=store.getRoot().builder();
  b2.child("x");
  store.merge(b2,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  String cp2=store.checkpoint(et2);
  Revision r2=Revision.fromString(cp2);
  assertEquals(2,store.getCheckpoints().size());
  assertEquals(r2,store.getCheckpoints().getOldestRevisionToKeep());
  store.release(cp2);
  assertEquals(1,store.getCheckpoints().size());
  assertEquals(r1,store.getCheckpoints().getOldestRevisionToKeep());
}
