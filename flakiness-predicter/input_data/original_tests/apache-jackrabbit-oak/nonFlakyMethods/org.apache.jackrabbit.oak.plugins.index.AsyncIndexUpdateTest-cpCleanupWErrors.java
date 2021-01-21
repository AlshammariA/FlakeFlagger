@Test public void cpCleanupWErrors() throws Exception {
  MemoryNodeStore store=new MemoryNodeStore();
  FaultyIndexEditorProvder provider=new FaultyIndexEditorProvder();
  NodeBuilder builder=store.getRoot().builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"rootIndex",true,false,ImmutableSet.of("foo"),null).setProperty(ASYNC_PROPERTY_NAME,"async");
  builder.child("testRoot").setProperty("foo","abc");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  assertTrue("Expecting no checkpoints",store.listCheckpoints().size() == 0);
  AsyncIndexUpdate async=new AsyncIndexUpdate("async",store,provider);
  async.run();
  assertTrue("Error should have been triggered by the commit",provider.isFailed());
  assertTrue("Expecting no checkpoints",store.listCheckpoints().size() == 0);
}
