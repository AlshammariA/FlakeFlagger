@Test public void failOnConflict() throws Exception {
  final Map<Thread,Semaphore> locks=Maps.newIdentityHashMap();
  NodeStore store=new MemoryNodeStore(){
    @Nonnull @Override public NodeState merge(    @Nonnull NodeBuilder builder,    @Nonnull CommitHook commitHook,    @Nullable CommitInfo info) throws CommitFailedException {
      Semaphore s=locks.get(Thread.currentThread());
      if (s != null) {
        s.acquireUninterruptibly();
      }
      return super.merge(builder,commitHook,info);
    }
  }
;
  IndexEditorProvider provider=new PropertyIndexEditorProvider();
  NodeBuilder builder=store.getRoot().builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"foo",false,ImmutableSet.of("foo"),null,TYPE,Collections.singletonMap(ASYNC_PROPERTY_NAME,"async"));
  builder.child("test").setProperty("foo","a");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  final AsyncIndexUpdate async=new AsyncIndexUpdate("async",store,provider);
  async.run();
  builder=store.getRoot().builder();
  builder.child("test").setProperty("foo","b");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  Thread t=new Thread(new Runnable(){
    @Override public void run(){
      async.run();
    }
  }
);
  Semaphore s=new Semaphore(0);
  locks.put(t,s);
  t.start();
  builder=store.getRoot().builder();
  builder.setChildNode("dummy").setProperty("foo","bar");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  while (!s.hasQueuedThreads()) {
    Thread.yield();
  }
  builder=store.getRoot().builder();
  builder.getChildNode(INDEX_DEFINITIONS_NAME).getChildNode("foo").getChildNode(":index").child("a").remove();
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  s.release(100);
  t.join();
  builder=store.getRoot().builder();
  assertNoConflictMarker(builder);
}
