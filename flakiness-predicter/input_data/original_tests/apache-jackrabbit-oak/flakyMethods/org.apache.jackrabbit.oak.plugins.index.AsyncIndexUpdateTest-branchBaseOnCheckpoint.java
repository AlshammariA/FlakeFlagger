@Test public void branchBaseOnCheckpoint() throws Exception {
  final Semaphore retrieve=new Semaphore(1);
  final Semaphore checkpoint=new Semaphore(0);
  NodeStore store=new MemoryNodeStore(){
    @CheckForNull @Override public NodeState retrieve(    @Nonnull String checkpoint){
      retrieve.acquireUninterruptibly();
      try {
        return super.retrieve(checkpoint);
      }
  finally {
        retrieve.release();
      }
    }
    @Nonnull @Override public String checkpoint(    long lifetime){
      try {
        return super.checkpoint(lifetime);
      }
  finally {
        checkpoint.release();
      }
    }
  }
;
  IndexEditorProvider provider=new PropertyIndexEditorProvider();
  NodeBuilder builder=store.getRoot().builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"foo",false,ImmutableSet.of("foo"),null,TYPE,Collections.singletonMap(ASYNC_PROPERTY_NAME,"async"));
  builder.child("test").setProperty("foo","a");
  builder.child("child");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  final AsyncIndexUpdate async=new AsyncIndexUpdate("async",store,provider);
  async.run();
  builder=store.getRoot().builder();
  builder.child("test").setProperty("foo","b");
  builder.child("child").setProperty("prop","value");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  Thread t=new Thread(new Runnable(){
    @Override public void run(){
      async.run();
    }
  }
);
  checkpoint.acquireUninterruptibly(checkpoint.availablePermits());
  retrieve.acquireUninterruptibly();
  t.start();
  retrieve.release();
  checkpoint.acquireUninterruptibly();
  builder=store.getRoot().builder();
  builder.child("child").remove();
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  retrieve.release();
  t.join();
  assertFalse(store.getRoot().hasChildNode("child"));
}
