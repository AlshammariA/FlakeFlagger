@Test public void gc() throws Exception {
  HashSet<String> set=setUp();
  MarkSweepGarbageCollector gc=new MarkSweepGarbageCollector(new SegmentBlobReferenceRetriever(store.getTracker()),(GarbageCollectableBlobStore)store.getBlobStore(),MoreExecutors.sameThreadExecutor(),"./target",2048,true,0);
  gc.collectGarbage();
  Set<String> existing=iterate();
  boolean empty=Sets.intersection(set,existing).isEmpty();
  assertTrue(empty);
}
