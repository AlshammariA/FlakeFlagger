@Test public void testPessimisticMerge() throws Exception {
  final SegmentNodeStore store=new SegmentNodeStore(new MemoryStore());
  final Semaphore semaphore=new Semaphore(0);
  final AtomicBoolean running=new AtomicBoolean(true);
  Thread background=new Thread(){
    @Override public void run(){
      for (int i=0; running.get(); i++) {
        try {
          NodeBuilder a=store.getRoot().builder();
          a.setProperty("foo","abc" + i);
          store.merge(a,EmptyHook.INSTANCE,CommitInfo.EMPTY);
          semaphore.release();
        }
 catch (        CommitFailedException e) {
          fail();
        }
      }
    }
  }
;
  background.start();
  semaphore.acquire();
  assertTrue(store.getRoot().hasProperty("foo"));
  assertFalse(store.getRoot().hasProperty("bar"));
  NodeBuilder b=store.getRoot().builder();
  b.setProperty("bar","xyz");
  store.setMaximumBackoff(100);
  store.merge(b,new CommitHook(){
    @Override @Nonnull public NodeState processCommit(    NodeState before,    NodeState after,    CommitInfo info){
      try {
        Thread.sleep(100);
      }
 catch (      InterruptedException e) {
        fail();
      }
      return after;
    }
  }
,CommitInfo.EMPTY);
  assertTrue(store.getRoot().hasProperty("foo"));
  assertTrue(store.getRoot().hasProperty("bar"));
  running.set(false);
  background.join();
}
