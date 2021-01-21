@Test public void testGetOldestRevisionToKeep() throws Exception {
  long et1=1000, et2=et1 + 1000;
  Revision r1=Revision.fromString(store.checkpoint(et1));
  NodeBuilder b2=store.getRoot().builder();
  b2.child("x");
  store.merge(b2,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  Revision r2=Revision.fromString(store.checkpoint(et2));
  assertNotSame(r1,r2);
  assertEquals(r2,store.getCheckpoints().getOldestRevisionToKeep());
  long starttime=clock.getTime();
  clock.waitUntil(starttime + et1 + 1);
  assertEquals(r2,store.getCheckpoints().getOldestRevisionToKeep());
  clock.waitUntil(starttime + et2 + 1);
  assertNull(store.getCheckpoints().getOldestRevisionToKeep());
}
