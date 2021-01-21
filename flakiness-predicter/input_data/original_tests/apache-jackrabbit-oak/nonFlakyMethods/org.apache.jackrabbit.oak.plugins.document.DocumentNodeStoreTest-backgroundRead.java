@Test public void backgroundRead() throws Exception {
  final Semaphore semaphore=new Semaphore(1);
  DocumentStore docStore=new MemoryDocumentStore();
  DocumentStore testStore=new TimingDocumentStoreWrapper(docStore){
    @Override public void invalidateCache(){
      super.invalidateCache();
      semaphore.acquireUninterruptibly();
      semaphore.release();
    }
  }
;
  final DocumentNodeStore store1=new DocumentMK.Builder().setAsyncDelay(0).setDocumentStore(testStore).setClusterId(1).getNodeStore();
  DocumentNodeStore store2=new DocumentMK.Builder().setAsyncDelay(0).setDocumentStore(docStore).setClusterId(2).getNodeStore();
  NodeBuilder builder=store2.getRoot().builder();
  builder.child("node2");
  store2.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  store2.runBackgroundOperations();
  assertFalse(store1.getRoot().hasChildNode("node2"));
  builder=store1.getRoot().builder();
  builder.child("node1");
  NodeState root=store1.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  semaphore.acquireUninterruptibly();
  Thread t=new Thread(new Runnable(){
    @Override public void run(){
      store1.runBackgroundOperations();
    }
  }
);
  t.start();
  while (!semaphore.hasQueuedThreads()) {
    Thread.sleep(10);
  }
  try {
    assertFalse(root.hasChildNode("node2"));
  }
  finally {
    semaphore.release();
  }
  t.join();
  root=store1.getRoot();
  assertTrue(root.hasChildNode("node2"));
  store1.dispose();
  store2.dispose();
}
