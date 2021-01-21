@Test public void afterCommitHook() throws CommitFailedException, InterruptedException {
  assumeTrue(store instanceof Observable);
  final AtomicReference<NodeState> observedRoot=new AtomicReference<NodeState>(null);
  final CountDownLatch latch=new CountDownLatch(2);
  ((Observable)store).addObserver(new Observer(){
    @Override public void contentChanged(    @Nonnull NodeState root,    @Nullable CommitInfo info){
      if (root.getChildNode("test").hasChildNode("newNode")) {
        observedRoot.set(checkNotNull(root));
        latch.countDown();
      }
    }
  }
);
  NodeState root=store.getRoot();
  NodeBuilder rootBuilder=root.builder();
  NodeBuilder testBuilder=rootBuilder.child("test");
  NodeBuilder newNodeBuilder=testBuilder.child("newNode");
  newNodeBuilder.setProperty("n",42);
  testBuilder.getChildNode("a").remove();
  store.merge(rootBuilder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  NodeState newRoot=store.getRoot();
  latch.await(2,TimeUnit.SECONDS);
  NodeState after=observedRoot.get();
  assertNotNull(after);
  assertTrue(after.getChildNode("test").getChildNode("newNode").exists());
  assertFalse(after.getChildNode("test").getChildNode("a").exists());
  assertEquals(42,(long)after.getChildNode("test").getChildNode("newNode").getProperty("n").getValue(LONG));
  assertEquals(newRoot,after);
}
