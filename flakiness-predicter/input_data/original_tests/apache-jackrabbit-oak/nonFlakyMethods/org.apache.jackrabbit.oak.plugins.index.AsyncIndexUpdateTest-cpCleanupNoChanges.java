@Test public void cpCleanupNoChanges() throws Exception {
  MemoryNodeStore store=new MemoryNodeStore();
  IndexEditorProvider provider=new PropertyIndexEditorProvider();
  assertTrue("Expecting no checkpoints",store.listCheckpoints().size() == 0);
  AsyncIndexUpdate async=new AsyncIndexUpdate("async",store,provider);
  async.run();
  assertTrue("Expecting no checkpoints",store.listCheckpoints().size() == 0);
}
